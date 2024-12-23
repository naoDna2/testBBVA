package com.naomi.pruebabbva.infrastructure.data.remote.dtos.login


import com.google.gson.annotations.SerializedName

/**
{
  "name": "exampleBBVA",
  "lastName": "example@bbva.com",
  "id": "bbvaPassword",
  "gender": "male",
  "age": 23
}
*/
data class LoginResponseDto(
    @SerializedName("age")
    val age: Int?,
    @SerializedName("gender")
    val gender: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("lastName")
    val lastName: String?,
    @SerializedName("name")
    val name: String?
)