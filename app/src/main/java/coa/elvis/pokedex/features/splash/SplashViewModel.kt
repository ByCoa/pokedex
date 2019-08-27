package coa.elvis.pokedex.features.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel internal constructor(private val splashRepository: SplashRepository) : ViewModel() {

  private val TIME_DELAY = 2000L

  val splashFinish = MutableLiveData<Boolean>().apply { value = false }

  fun start() {
    viewModelScope.launch {
      delay(TIME_DELAY)
      splashFinish.value = true
    }
  }
}