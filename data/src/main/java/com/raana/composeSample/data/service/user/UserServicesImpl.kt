package com.raana.composeSample.data.service.user

import com.raana.composeSample.data.base.getResult
import com.raana.composeSample.domain.repository.user.UserRepository
import com.raana.composeSample.domain.repository.user.model.User
import javax.inject.Inject

class UserServicesImpl @Inject constructor(private val userService: UserService) : UserRepository {
    override suspend fun getUsers(): Result<List<User>> {
        return getResult { userService.getUsers() }
    }
}