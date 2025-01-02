package com.example.androidapp

import android.util.Log

object CredentialsManager {
    private val credentialsMap = mutableMapOf<String, String>()

    fun register(email: String, password: String): Boolean {
        return if (credentialsMap.containsKey(email)) {
            Log.d("CredentialsManager", "Registration failed: Email $email already exists")
            false
        } else {
            credentialsMap[email] = password
            Log.d("CredentialsManager", "Registration successful: $email")
            true
        }
    }

    fun login(email: String, password: String): Boolean {
        val isValid = credentialsMap[email] == password
        Log.d("CredentialsManager", "Login attempt for $email: $isValid")
        return isValid
    }

    // 11.11.24 task test code for check correct or wrong mail and password

    fun isEmailValid(email: String): Boolean {
        if (email.isBlank()) return false
        val emailRegex = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}\$".toRegex()
        return emailRegex.matches(email)
    }

    fun isPasswordValid(password: String): Boolean {
        return password.isNotBlank()
    }
}