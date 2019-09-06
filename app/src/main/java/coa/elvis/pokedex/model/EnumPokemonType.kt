package coa.elvis.pokedex.model

import coa.elvis.pokedex.R

enum class EnumPokemonType {
  Normal,
  Fighting,
  Flying,
  Poison,
  Ground,
  Rock,
  Bug,
  Ghost,
  Steel,
  Fire,
  Water,
  Grass,
  Electric,
  Psychic,
  Ice,
  Dragon,
  Dark,
  Fairy,
  Unknown,
  Shadow,
  Empty;

  fun background() : Int {
    when(this){
      Normal-> return R.color.type_normal
      Fighting-> return R.color.type_fighting
      Flying-> return R.color.type_flying
      Poison-> return R.color.type_poison
      Ground-> return R.color.type_ground
      Rock-> return R.color.type_rock
      Bug-> return R.color.type_bug
      Ghost-> return R.color.type_ghost
      Steel-> return R.color.type_steel
      Fire-> return R.color.type_fire
      Water-> return R.color.type_water
      Grass-> return R.color.type_grass
      Electric-> return R.color.type_electric
      Psychic-> return R.color.type_phychic
      Ice-> return R.color.type_ice
      Dragon-> return R.color.type_dragon
      Dark-> return R.color.type_dark
      Fairy-> return R.color.type_fairy
      Unknown-> return R.color.type_typeless
      Shadow-> return R.color.type_shadow
      Empty-> return android.R.color.transparent
    }
  }
}