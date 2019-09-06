package coa.elvis.pokedex.common.view

import android.content.Context
import android.content.Intent
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coa.elvis.pokedex.R
import coa.elvis.pokedex.common.extensions.typesToEnum
import coa.elvis.pokedex.common.networking.response.Pokemon
import coa.elvis.pokedex.model.EnumPokemonType
import com.bumptech.glide.Glide


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

@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: AppCompatImageView, imageUrl: String?) {
  if (!imageUrl.isNullOrEmpty()) {
    Glide.with(view.context)
      .load(imageUrl)
      .placeholder(R.drawable.img_whos_that_pokemon)
      .into(view)
  }
}


@BindingAdapter("data")
fun <T> setRecyclerViewData(recyclerView: RecyclerView, data: T) {
  if (recyclerView.adapter is BindableAdapter<*>) {
    if (data !is Pokemon) {
      (recyclerView.adapter as BindableAdapter<T>).setData(data)
    } else {
      (recyclerView.adapter as BindableAdapter<List<EnumPokemonType>>).setData((data as Pokemon).typesToEnum())
    }
  }
}

@BindingAdapter("backgroundType")
fun setTextViewBackground(textView: AppCompatTextView, resource: Int){
  val bgShape = textView.background as GradientDrawable
  bgShape.setColor(ContextCompat.getColor(textView.context,resource))

}