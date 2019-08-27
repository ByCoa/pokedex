package coa.elvis.pokedex.features.splash

import android.os.Bundle
import androidx.lifecycle.Observer
import coa.elvis.pokedex.R
import coa.elvis.pokedex.common.base.BaseActivity
import coa.elvis.pokedex.common.view.startCleanActivity
import coa.elvis.pokedex.features.home.HomeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : BaseActivity() {

  private val splashViewModel: SplashViewModel by viewModel()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_splash)
    splashViewModel.start()
    setObservers()
  }

  fun setObservers() {
    splashViewModel.splashFinish.observe(
      this,
      Observer<Boolean> { splashFinished: Boolean -> goToHome(splashFinished) })
  }

  fun goToHome(splashFinished: Boolean) {
    if (splashFinished) {
      startCleanActivity(HomeActivity::class.java) { finish() }
    }
  }

  override fun getToolbarActionImage(): Int = 0

  override fun onToolbarActionClick() {}

  override fun getToolbarTitle(): Int = 0
}
