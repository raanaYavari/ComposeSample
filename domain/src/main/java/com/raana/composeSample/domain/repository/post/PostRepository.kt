package com.raana.composeSample.domain.repository.post

import com.raana.composeSample.domain.repository.post.model.Post

interface PostRepository {
    suspend fun getPosts(): Result<List<Post>>
    suspend fun getPostDetail(id: Int): Result<Post>
}