package com.naomi.pruebabbva.infrastructure.repositories

import android.util.Log
import com.naomi.pruebabbva.domain.entities.User
import com.naomi.pruebabbva.domain.repositories.AuthRepository
import com.naomi.pruebabbva.infrastructure.data.local.spreferences.PreferencesManager
import com.naomi.pruebabbva.infrastructure.data.remote.apis.BbvaApi
import com.naomi.pruebabbva.infrastructure.data.remote.apis.BbvaImagesApi
import com.naomi.pruebabbva.infrastructure.data.remote.dtos.login.LoginRequestDto

class AuthRepositoryImpl(
    private val bbvaApi: BbvaApi,
    private val bbvaImagesApi: BbvaImagesApi,
    private val preferencesManager: PreferencesManager
) : AuthRepository {
    override suspend fun login(user: String, pass: String): User {
        val request = LoginRequestDto(
            email = user,
            password = pass,
            username = user,
        )
        val response = bbvaApi.login(request)
        val user = User(
            id = response.id,
            name = response.name,
            age = response.age,
            gender = response.gender,
            lastName = response.lastName
        )
        preferencesManager.saveUser(user)
        return user
    }

    override suspend fun isLoggedIn(): Boolean {
        val isLoggedIn = preferencesManager.isLoggedIn()
        return isLoggedIn
    }

    override suspend fun getProfile(): User {
        var urlImage:String ?= null
        try{
            val respImageProfile = bbvaImagesApi.getImagesProfile()
            urlImage = respImageProfile.message

        }catch (ex:Exception){
            Log.w("AuthRepositoryImpl", "getProfile", ex)
        }

        val user = preferencesManager.getUser()
        user!!.urlImage = urlImage
        return user
    }
}