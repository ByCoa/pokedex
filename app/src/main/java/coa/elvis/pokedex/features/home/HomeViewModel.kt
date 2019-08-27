package coa.elvis.pokedex.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coa.elvis.pokedex.common.networking.Status
import coa.elvis.pokedex.repository.remote.PokemonRemoteDataSource
import kotlinx.coroutines.GlobalScope.coroutineContext
import kotlinx.coroutines.launch

class HomeViewModel internal constructor(private val homeRepository: PokemonRemoteDataSource) : ViewModel() {

  fun fetchPokemon(keyValueName: String) {
    viewModelScope.launch(context = coroutineContext) {
      val pokemonResponse = homeRepository.searchPokemon(keyValueName)
      when (pokemonResponse.status) {
        Status.SUCCESS -> {

        }
        Status.ERROR -> {

        }
      }
    }
  }
}