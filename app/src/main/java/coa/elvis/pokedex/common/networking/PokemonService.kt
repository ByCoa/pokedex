package coa.elvis.pokedex.common.networking

import coa.elvis.pokedex.common.networking.resource.ApiResponse
import coa.elvis.pokedex.common.networking.response.Pokemon
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface PokemonService {

  @Headers("Accept: application/json")
  @GET("pokemon/{keyNameValue}/")
  fun fetchPokemon(@Path("keyNameValue") keyNameValue: String): Deferred<ApiResponse<Pokemon>>

}