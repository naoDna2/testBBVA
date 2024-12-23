package com.naomi.pruebabbva.infrastructure.data.remote.apis

import com.naomi.pruebabbva.infrastructure.data.remote.dtos.profile.ProfileResponseDto
import retrofit2.http.GET

interface BbvaImagesApi {
    @GET("/api/breeds/image/random")
    suspend fun getImagesProfile(): ProfileResponseDto
}