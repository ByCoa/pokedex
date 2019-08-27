package coa.elvis.pokedex.common.networking.response

data class Ability(
  val ability: AbilityX,
  val is_hidden: Boolean,
  val slot: Int
)