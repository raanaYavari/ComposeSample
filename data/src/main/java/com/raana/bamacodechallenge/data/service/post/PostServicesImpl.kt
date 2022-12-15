package com.raana.bamacodechallenge.data.service.post

import com.raana.bamacodechallenge.domain.repository.post.PostRepository
import com.raana.bamacodechallenge.domain.repository.post.model.Post
import javax.inject.Inject

class PostServicesImpl @Inject constructor(
    private val service: PostService
):PostRepository {
    override suspend fun getPosts(): Result<List<Post>> {
        TODO("Not yet implemented")
    }

    override suspend fun getPostDetail(): Result<Post> {
        TODO("Not yet implemented")
    }


}