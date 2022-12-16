package com.raana.bamacodechallenge.domain.usecase.post

import com.raana.bamacodechallenge.domain.repository.post.PostRepository
import com.raana.bamacodechallenge.domain.repository.post.model.Post

class GetPostDetailUseCase constructor(private val postRepository: PostRepository) {

    suspend fun invoke(id: Int): Result<Post> {
        return postRepository.getPostDetail(id)
    }
}