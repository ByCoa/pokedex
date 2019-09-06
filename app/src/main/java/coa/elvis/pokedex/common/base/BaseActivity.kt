package coa.elvis.pokedex.common.base

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatImageView
import coa.elvis.pokedex.R
import kotlinx.android.synthetic.main.view_toolbar.*


abstract class BaseActivity : AppCompatActivity() {
  override fun setContentView(layoutResID: Int) {
    super.setContentView(layoutResID)
    toolbar?.apply {
      this.title = ""
      this.findViewById<AppCompatImageButton>(R.id.toolbar_action_btn).apply {
        this.setImageResource(getToolbarActionImage())
        this.setOnClickListener { onToolbarActionClick() }
      }

      this.findViewById<AppCompatImageView>(R.id.toolbar_title).apply {
        this.setImageResource(getToolbarTitle())
      }

      setSupportActionBar(toolbar)

    }
  }

  abstract fun getToolbarActionImage(): Int

  abstract fun onToolbarActionClick()

  abstract fun getToolbarTitle(): Int
}