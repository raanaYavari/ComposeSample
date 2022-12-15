package com.raana.bamacodechallenge.data.service.post

import com.raana.bamacodechallenge.domain.repository.post.model.Post
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path

interface PostService {

    @GET("/posts")
    suspend fun getPosts(): List<Post>

    @GET("/posts/{Id}")
    suspend fun getPostDetail(@Path("Id") id: Int): Post
}