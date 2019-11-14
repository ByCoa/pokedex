package coa.elvis.pokedex.common.di

import coa.elvis.pokedex.features.home.HomeRepository
import coa.elvis.pokedex.features.home.HomeViewModel
import coa.elvis.pokedex.features.splash.SplashRepository
import coa.elvis.pokedex.features.splash.SplashViewModel
import coa.elvis.pokedex.repository.remote.PokemonRemoteDataSource
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


private val appModule = module {
  factory { String() }
}



private val splashModule = module {
  viewModel { SplashViewModel(get()) }
  factory { SplashRepository() }
}

private val homeModule = module {
  viewModel { HomeViewModel(get()) }
  factory { HomeRepository(get()) }
  factory { PokemonRemoteDataSource(get()) }
}

val allAppModules =
  listOf(
    appModule,
    splashModule,
    homeModule
  )