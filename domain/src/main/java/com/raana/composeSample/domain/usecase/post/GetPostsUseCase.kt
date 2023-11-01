package com.raana.composeSample.domain.usecase.post

import com.raana.composeSample.domain.repository.post.PostRepository
import com.raana.composeSample.domain.repository.post.model.Post
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(private val postRepository: PostRepository) {

    suspend fun invoke(): Result<List<Post>> {
        return postRepository.getPosts()
    }
}