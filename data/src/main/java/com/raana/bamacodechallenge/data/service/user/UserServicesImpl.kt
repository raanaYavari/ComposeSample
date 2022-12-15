package com.raana.bamacodechallenge.data.service.user

import com.raana.bamacodechallenge.domain.repository.user.UserRepository
import com.raana.bamacodechallenge.domain.repository.user.model.User
import javax.inject.Inject

class UserServicesImpl @Inject constructor(private val userService: UserService) : UserRepository {
    override suspend fun getUsers(): Result<List<User>> {
        TODO("Not yet implemented")
    }
}