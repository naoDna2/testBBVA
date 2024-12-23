package com.naomi.pruebabbva.infrastructure.data.remote.dtos.login


import com.google.gson.annotations.SerializedName

/**
{
  "username": "string",
  "email": "string",
  "password": "string"
}
*/
data class LoginRequestDto(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("username")
    val username: String
)