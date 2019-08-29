package coa.elvis.pokedex.common.view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun View.show() {
  visibility = View.VISIBLE
}

fun View.hide() {
  visibility = View.GONE
}

inline fun Context.startCleanActivity(clazz: Class<out Any>, bloc: () -> Unit) {
  val intent = Intent(this, clazz)
  intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
  startActivity(intent)
  bloc()
}

fun ViewGroup.inflate(resId: Int, attach: Boolean = false): View {
  return LayoutInflater.from(context).inflate(resId, this, attach)
}