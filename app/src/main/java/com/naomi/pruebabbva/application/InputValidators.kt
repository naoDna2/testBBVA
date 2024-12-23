package com.naomi.pruebabbva.application

object InputValidators {

    fun validateEmail(email: String): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
        return email.isNotEmpty() && Regex(emailRegex).matches(email)
    }
}