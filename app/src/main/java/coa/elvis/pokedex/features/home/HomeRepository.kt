package coa.elvis.pokedex.features.home

import coa.elvis.pokedex.common.networking.Resource
import coa.elvis.pokedex.common.networking.Status
import coa.elvis.pokedex.common.networking.response.Pokemon
import coa.elvis.pokedex.repository.remote.PokemonRemoteDataSource

class HomeRepository(private val pokemonRemoteDataSource: PokemonRemoteDataSource) {

  suspend fun fetchPokemon(keyValueName: String): Resource<Pokemon> {
    val pokemon = pokemonRemoteDataSource.searchPokemon(keyValueName)
    return if (pokemon.status != Status.ERROR) {
      pokemon
    } else {
      Resource.error("", null)
    }
  }
}