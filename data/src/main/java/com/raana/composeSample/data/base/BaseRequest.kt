package com.raana.composeSample.data.base

import retrofit2.Response

suspend fun <T> getResult(call: suspend () -> Response<T>): Result<T> {
    return try {
        val response = call()
        val body = response.body()
        if (response.isSuccessful && body != null) {
            Result.success(body)
        } else {
            Result.failure(Throwable(response.message()))
        }
    } catch (e: Exception) {
        Result.failure(Throwable(e))
    }
}


