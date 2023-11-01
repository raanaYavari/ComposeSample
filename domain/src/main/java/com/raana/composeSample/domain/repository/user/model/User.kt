package com.raana.composeSample.domain.repository.user.model

import android.provider.ContactsContract.CommonDataKinds.Phone
import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class User(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("username") val username: String,
    @SerialName("email") val email: String,
    @SerialName("phone") val phone: String,
    @SerialName("website") val website: String,
    @SerialName("address") val address: Address,
    @SerialName("company") val company: Company,
)