package coa.elvis.pokedex.common.networking.response

class Empty

enum class EmptyResponse(val response: String) {
  SUCCESS("success"),
  ERROR("error")
}
