package com.naomi.pruebabbva.infrastructure.data.remote.apis

import com.naomi.pruebabbva.infrastructure.data.remote.dtos.login.LoginRequestDto
import com.naomi.pruebabbva.infrastructure.data.remote.dtos.login.LoginResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface BbvaApi {
    @POST("/login")
    suspend fun login(@Body request: LoginRequestDto): LoginResponseDto
}