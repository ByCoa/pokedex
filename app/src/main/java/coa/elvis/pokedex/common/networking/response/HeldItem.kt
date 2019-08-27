package coa.elvis.pokedex.common.networking.response

data class HeldItem(
  val item: Item,
  val version_details: List<VersionDetailX>
)