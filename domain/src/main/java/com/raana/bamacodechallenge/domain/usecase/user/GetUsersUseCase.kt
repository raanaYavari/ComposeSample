package com.raana.bamacodechallenge.domain.usecase.user

import com.raana.bamacodechallenge.domain.repository.user.UserRepository
import com.raana.bamacodechallenge.domain.repository.user.model.User

class GetUsersUseCase constructor(private val userRepository: UserRepository) {

    suspend fun invoke(): Result<List<User>> {
        return userRepository.getUsers()
    }
}