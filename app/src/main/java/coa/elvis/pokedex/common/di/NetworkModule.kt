package coa.elvis.pokedex.common.di

import coa.elvis.pokedex.BuildConfig
import coa.elvis.pokedex.common.networking.PokemonService
import coa.elvis.pokedex.common.networking.resource.ApiResponseCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

  single { getService(get()) }

  single { getRetrofit(get()) }

  single { getHttpClient() }
}


private fun getService(retrofit: Retrofit): PokemonService {
  return retrofit.create(PokemonService::class.java)
}

private fun getRetrofit(okHttpClient: OkHttpClient): Retrofit {
  return Retrofit.Builder()
    .baseUrl(BuildConfig.HOST)
    .addCallAdapterFactory(ApiResponseCallAdapterFactory())
    .addConverterFactory(GsonConverterFactory.create())
    .client(okHttpClient)
    .build()
}

private fun getHttpClient(): OkHttpClient {
  return OkHttpClient.Builder().run {
    readTimeout(30, TimeUnit.SECONDS)
    writeTimeout(30, TimeUnit.SECONDS)
    addInterceptor(HttpLoggingInterceptor().setLevel(httpLogLevel))
    build()
  }
}

private val httpLogLevel by lazy {
  if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
}