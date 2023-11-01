package com.raana.composeSample.domain.usecase.user

import com.raana.composeSample.domain.repository.user.UserRepository
import com.raana.composeSample.domain.repository.user.model.User
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val userRepository: UserRepository) {

    suspend fun invoke(): Result<List<User>> {
        return userRepository.getUsers()
    }
}