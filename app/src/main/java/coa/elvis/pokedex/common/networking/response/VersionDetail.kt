package coa.elvis.pokedex.common.networking.response

data class VersionDetail(
  val encounter_details: List<EncounterDetail>,
  val max_chance: Int,
  val version: Version
)