package com.naomi.pruebabbva.infrastructure.data.remote.dtos.profile


import com.google.gson.annotations.SerializedName

/**
{
    "message": "https://images.dog.ceo/breeds/australian-kelpie/IMG_3675.jpg",
    "status": "success"
}
*/
data class ProfileResponseDto(
    @SerializedName("message")
    val message: String?,
    @SerializedName("status")
    val status: String?
)