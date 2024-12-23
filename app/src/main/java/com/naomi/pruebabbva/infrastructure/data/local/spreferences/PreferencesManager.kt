package com.naomi.pruebabbva.infrastructure.data.local.spreferences

import android.content.SharedPreferences
import com.google.gson.Gson
import com.naomi.pruebabbva.domain.entities.User
import javax.inject.Inject

class PreferencesManager @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val gson: Gson = Gson(),
) {
    companion object {
        private const val USER_KEY = "username"
    }

    fun saveUser(user: User?) {
        if(user != null){
            val userString = gson.toJson(user);
            if(!userString.isNullOrBlank()){
                sharedPreferences.edit().putString(USER_KEY, userString).apply()
            }
        }
    }

    fun getUser(): User? {
        val userString =  sharedPreferences.getString(USER_KEY, null)
        if(userString.isNullOrBlank()){
            return null
        }
        val user = gson.fromJson(userString,User::class.java)
        return user
    }

    fun isLoggedIn(): Boolean {
        val userString =  sharedPreferences.getString(USER_KEY, null)
        return !userString.isNullOrBlank()
    }

    fun clear() {
        sharedPreferences.edit().clear().apply()
    }
}
