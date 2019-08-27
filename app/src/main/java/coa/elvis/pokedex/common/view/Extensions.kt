package coa.elvis.pokedex.common.view

import android.content.Context
import android.content.Intent
import android.view.View

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