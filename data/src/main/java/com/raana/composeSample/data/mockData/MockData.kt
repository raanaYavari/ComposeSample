package com.raana.composeSample.data.mockData

import com.raana.composeSample.domain.repository.post.model.Post
import com.raana.composeSample.domain.repository.user.model.Address
import com.raana.composeSample.domain.repository.user.model.Company
import com.raana.composeSample.domain.repository.user.model.Geo
import com.raana.composeSample.domain.repository.user.model.User

object MockPostData {
    val posts = listOf(
        Post(1, "Mock Post 1", "This is the body of mock post 1."),
        Post(2, "Mock Post 2", "This is the body of mock post 2."),
        Post(3, "Mock Post 3", "This is the body of mock post 3.")
    )
    val postDetail = Post(1, "Mock Post 1", "This is the body of mock post 1.")
}

object MockUserData {
    val users = listOf(
        User(
            1, "John Doe", "johndoe", "johndoe@example.com",
            "123-456-7890", "johndoe.com",
            Address("123 Main St", "Suite 101", "Cityville", "12345", Geo(53.0, 12.0)),
            Company("ABC Inc.", "Catch Phrase", "BS Info")
        ),
    )
}