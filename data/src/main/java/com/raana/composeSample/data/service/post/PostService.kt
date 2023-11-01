package com.raana.composeSample.data.service.post

import com.raana.composeSample.domain.repository.post.model.Post
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path

interface PostService {

    @GET("/posts")
    suspend fun getPosts(): Response<List<Post>>

    @GET("/posts/{Id}")
    suspend fun getPostDetail(@Path("Id") id: Int): Response<Post>
}