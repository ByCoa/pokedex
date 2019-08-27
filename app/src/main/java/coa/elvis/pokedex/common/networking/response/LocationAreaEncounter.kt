package coa.elvis.pokedex.common.networking.response

data class LocationAreaEncounter(
  val location_area: LocationArea,
  val version_details: List<VersionDetail>
)