package com.raana.bamacodechallenge.domain.usecase.post

import com.raana.bamacodechallenge.domain.repository.post.PostRepository
import com.raana.bamacodechallenge.domain.repository.post.model.Post
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(private val postRepository: PostRepository) {

    suspend fun invoke(): Result<List<Post>> {
        return postRepository.getPosts()
    }
}