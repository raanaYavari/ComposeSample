package com.raana.composeSample.data.service.user

import com.raana.composeSample.domain.repository.user.model.User
import retrofit2.Response
import retrofit2.http.GET

interface UserService {

    @GET("/users")
    suspend fun getUsers(): Response<List<User>>
}