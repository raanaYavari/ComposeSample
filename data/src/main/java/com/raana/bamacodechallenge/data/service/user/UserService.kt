package com.raana.bamacodechallenge.data.service.user

import retrofit2.http.GET

interface UserService {

    @GET("/users")
    suspend fun getUsers(): List<Unit>
}