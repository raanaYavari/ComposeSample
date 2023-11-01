package com.raana.composeSample.data.service.post

import com.raana.composeSample.data.base.getResult
import com.raana.composeSample.domain.repository.post.PostRepository
import com.raana.composeSample.domain.repository.post.model.Post
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