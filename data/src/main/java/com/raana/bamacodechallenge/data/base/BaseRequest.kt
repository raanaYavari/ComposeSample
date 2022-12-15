package com.raana.bamacodechallenge.data.base

import retrofit2.Response

suspend fun <T> getResult(call: suspend () -> Response<T>): CustomResponse<T> {
    return try {
        val response = call()
        if (response.isSuccessful) {
            val body = response.body()
            CustomResponse.success(body)
        } else {
            throw Exception(response.message())
        }
    } catch (e: Exception) {
        return CustomResponse.fail(e.message)
    }
}


