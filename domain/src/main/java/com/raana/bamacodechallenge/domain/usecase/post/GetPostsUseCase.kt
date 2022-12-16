package com.raana.bamacodechallenge.domain.usecase.post

import com.raana.bamacodechallenge.domain.repository.post.PostRepository
import com.raana.bamacodechallenge.domain.repository.post.model.Post

class GetPostsUseCase constructor(private val postRepository: PostRepository) {

    suspend fun invoke(): Result<List<Post>> {
        return postRepository.getPosts()
    }
}