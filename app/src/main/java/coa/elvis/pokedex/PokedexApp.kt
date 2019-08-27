package coa.elvis.pokedex

import android.app.Application
import coa.elvis.pokedex.common.di.allAppModules
import coa.elvis.pokedex.common.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PokedexApp : Application() {

  override fun onCreate() {
    super.onCreate()
    startKoin {
      androidLogger()
      androidContext(this@PokedexApp)
      modules(listOf(networkModule, *allAppModules.toTypedArray()))
    }
  }
}