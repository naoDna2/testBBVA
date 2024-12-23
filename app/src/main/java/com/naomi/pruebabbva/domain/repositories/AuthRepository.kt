package com.naomi.pruebabbva.domain.repositories

import com.naomi.pruebabbva.domain.entities.User

interface AuthRepository {
    suspend fun login(user:String, pass: String):User
    suspend fun isLoggedIn():Boolean
    suspend fun getProfile():User
}