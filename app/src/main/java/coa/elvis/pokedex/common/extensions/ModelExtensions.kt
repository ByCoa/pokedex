package coa.elvis.pokedex.common.extensions

import android.annotation.SuppressLint
import coa.elvis.pokedex.common.networking.response.Pokemon
import coa.elvis.pokedex.common.networking.response.Type
import coa.elvis.pokedex.model.EnumPokemonType

@SuppressLint("DefaultLocale")
fun Pokemon.typesToEnum() : List<EnumPokemonType> {
  val typeResult = arrayListOf<EnumPokemonType>()
  if (!types.isNullOrEmpty()) {
    types.forEach {
      typeResult.add(EnumPokemonType.valueOf(it.type.name.capitalize()))
    }
  }
  return typeResult
}

@SuppressLint("DefaultLocale")
fun Type.typeEnum() : EnumPokemonType{
  return EnumPokemonType.valueOf(type.name.capitalize())
}

