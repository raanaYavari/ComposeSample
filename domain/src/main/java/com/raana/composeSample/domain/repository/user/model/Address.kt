package com.raana.composeSample.domain.repository.user.model

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class Address(
    @SerialName("street") val street: String,
    @SerialName("suite") val suite: String,
    @SerialName("city") val city: String,
    @SerialName("zipcode") val zipcode: String,
    @SerialName("geo") val geo: Geo,
) {
    override fun toString(): String {
        return "$city, $suite, $street, $zipcode"
    }
}