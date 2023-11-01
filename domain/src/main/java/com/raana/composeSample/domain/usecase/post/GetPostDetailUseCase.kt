package com.raana.composeSample.domain.usecase.post

import com.raana.composeSample.domain.repository.post.PostRepository
import com.raana.composeSample.domain.repository.post.model.Post
import javax.inject.Inject

class GetPostDetailUseCase @Inject constructor(private val postRepository: PostRepository) {

    suspend fun invoke(id: Int): Result<Post> {
        return postRepository.getPostDetail(id)
    }
}