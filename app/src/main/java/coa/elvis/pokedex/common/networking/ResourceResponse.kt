package coa.elvis.pokedex.common.networking

/**
 * A generic class that holds a value with its loading status.
 * */
data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
  companion object {
    fun <T> success(data: T?): Resource<T> {
      return Resource(Status.SUCCESS, data, null)
    }

    fun <T> error(msg: String, data: T?): Resource<T> {
      return Resource(Status.ERROR, data, msg)
    }
  }

  fun hasError() = status == Status.ERROR
}

enum class Status { SUCCESS, ERROR }