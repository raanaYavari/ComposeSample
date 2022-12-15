package com.raana.bamacodechallenge.domain.repository.user.model

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class Company(
    @SerialName("name") val name: String,
    @SerialName("catchPhrase") val catchPhrase: String,
    @SerialName("bs") val bs: String,
)