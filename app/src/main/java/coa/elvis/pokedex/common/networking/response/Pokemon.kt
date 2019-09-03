package coa.elvis.pokedex.common.networking.response

import coa.elvis.pokedex.common.extensions.EMPTY_STR

data class Pokemon(
  val abilities: List<Ability>,
  val base_experience: Int,
  val forms: List<Form>,
  val game_indices: List<GameIndice>,
  val height: Int,
  val held_items: List<HeldItem>,
  val id: Int,
  val is_default: Boolean,
  //val location_area_encounters: List<LocationAreaEncounter>,
  val moves: List<Move>,
  val name: String,
  val order: Int,
  val species: Species,
  val sprites: Sprites,
  val stats: List<Stat>,
  val types: List<Type>,
  val weight: Int
) {

  val capitalizeName: String get() = if (name.isNotEmpty()) name.capitalize() else EMPTY_STR
  val formattedId: String get() = String.format("N.º%03d", id)
}