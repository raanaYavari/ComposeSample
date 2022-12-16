package com.raana.bamacodechallenge.data.service.post

import com.raana.bamacodechallenge.data.base.CustomResponse
import com.raana.bamacodechallenge.data.base.getResult
import com.raana.bamacodechallenge.domain.repository.post.PostRepository
import com.raana.bamacodechallenge.domain.repository.post.model.Post
import javax.inject.Inject

class PostServicesImpl @Inject constructor(
    private val service: PostService
):PostRepository {
    override suspend fun getPosts(): Result<List<Post>> {
       return getResult { service.getPosts() }
    }

    override suspend fun getPostDetail(id:Int): Result<Post> {
        return getResult { service.getPostDetail(id) }
    }


}