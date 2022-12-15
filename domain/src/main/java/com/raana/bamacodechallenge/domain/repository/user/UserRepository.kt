package com.raana.bamacodechallenge.domain.repository.user

import com.raana.bamacodechallenge.domain.repository.user.model.User


interface UserRepository {
    suspend fun getUsers(): Result<List<User>>
}