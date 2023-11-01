package com.raana.composeSample.domain.repository.user

import com.raana.composeSample.domain.repository.user.model.User


interface UserRepository {
    suspend fun getUsers(): Result<List<User>>
}