package com.raana.bamacodechallenge.data.service.post

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path

interface PostService {

    @GET("/posts")
    suspend fun getPosts(): List<Unit>

    @GET("/posts/{Id}")
    suspend fun getPostDetail(@Path("Id") id: Int): Unit
}