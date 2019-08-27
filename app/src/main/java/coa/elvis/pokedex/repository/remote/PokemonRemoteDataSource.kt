package coa.elvis.pokedex.repository.remote

import coa.elvis.pokedex.common.networking.PokemonService
import coa.elvis.pokedex.common.networking.Resource
import coa.elvis.pokedex.common.networking.resource.ApiEmptyResponse
import coa.elvis.pokedex.common.networking.resource.ApiErrorResponse
import coa.elvis.pokedex.common.networking.resource.ApiSuccessResponse
import coa.elvis.pokedex.common.networking.response.Pokemon

class PokemonRemoteDataSource(private val service: PokemonService) {

  suspend fun searchPokemon(keyValueName: String): Resource<Pokemon> {
    val response = service.fetchPokemon(keyValueName).await()
    return when (response) {
      is ApiSuccessResponse -> Resource.success(response.body)
      is ApiEmptyResponse -> Resource.error("There is no data", null)
      is ApiErrorResponse -> Resource.error(response.errorMessage, null)
    }
  }
}
