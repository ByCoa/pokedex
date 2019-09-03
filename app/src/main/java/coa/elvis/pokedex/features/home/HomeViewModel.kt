package coa.elvis.pokedex.features.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coa.elvis.pokedex.common.networking.Resource
import coa.elvis.pokedex.common.networking.Status
import coa.elvis.pokedex.common.networking.response.Pokemon
import coa.elvis.pokedex.repository.remote.PokemonRemoteDataSource
import kotlinx.coroutines.GlobalScope.coroutineContext
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch

class HomeViewModel internal constructor(private val homeRepository: PokemonRemoteDataSource) : ViewModel() {

  val pokemonsMutableLiveData = MutableLiveData<List<Pokemon>>()

  val pokemonDataUpdated = MutableLiveData<Boolean>().apply { value = false }

  var pokemonList = arrayListOf<Pokemon>()


  fun start() {
    pokemonsMutableLiveData.value = pokemonList
    fetchNinePokemon()
  }


  fun fetchPokemon(keyValueName: String) {
    viewModelScope.launch(context = coroutineContext) {
      val pokemonResponse = homeRepository.searchPokemon(keyValueName)
      when (pokemonResponse.status) {
        Status.SUCCESS -> {
          println("Name " + pokemonResponse.data!!.name)
        }
        Status.ERROR -> {
          println("Error" + pokemonResponse.message)
        }
      }
    }
  }

  private fun fetchNinePokemon() {
    viewModelScope.launch {
      val deferredList = listOf(
        async { homeRepository.searchPokemon("1") },
        async { homeRepository.searchPokemon("2") },
        async { homeRepository.searchPokemon("3") },
        async { homeRepository.searchPokemon("4") },
        async { homeRepository.searchPokemon("5") },
        async { homeRepository.searchPokemon("6") },
        async { homeRepository.searchPokemon("7") },
        async { homeRepository.searchPokemon("8") },
        async { homeRepository.searchPokemon("9") })
      deferredList.awaitAll().forEach {
        pokemonList.add(processPokemonResponse(it))
      }
      okResponse()
    }
  }

  fun okResponse() {
    pokemonsMutableLiveData.value = pokemonList
  }

  private fun processPokemonResponse(pokemonResponse: Resource<Pokemon>): Pokemon {
    when (pokemonResponse.status) {
      Status.SUCCESS -> {
        println("Name pokemon: " + pokemonResponse.data!!.name + " Sprite front: " + pokemonResponse.data.sprites.front_default)

      }
      Status.ERROR -> {
        println("Error" + pokemonResponse.message)
      }
    }
    return pokemonResponse.data!!
  }
}