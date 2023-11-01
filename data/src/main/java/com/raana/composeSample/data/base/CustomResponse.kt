package com.raana.composeSample.data.base


data class CustomResponse<T>(
    val status: Status,
    var data: T? = null,
    val message: String? = null,
    val title: String? = null,
) {

    enum class Status() {
        SUCCESS,
        FAIL,
        LOADING
    }

    companion object {
        fun <T> success(data: T?): CustomResponse<T> =
            CustomResponse(status = Status.SUCCESS, data = data)

        fun <T> fail(message: String?): CustomResponse<T> =
            CustomResponse(status = Status.FAIL, message = message)

        fun <T> loading(): CustomResponse<T> =
            CustomResponse(status = Status.LOADING)
    }

    override fun toString(): String {
        return "Result(status=$status, data=$data, message=$message)"
    }

}