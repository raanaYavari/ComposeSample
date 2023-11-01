package com.raana.composeSample.domain.repository.user.model

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class Geo (
    @SerialName("lat") val lat:Double,
    @SerialName("lng") val lng:Double,
)