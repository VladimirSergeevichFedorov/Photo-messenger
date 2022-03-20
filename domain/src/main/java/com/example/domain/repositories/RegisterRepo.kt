package com.example.domain.repositories

interface RegisterRepo {
    suspend fun saveLogin(login: String)
    suspend fun savePinCode(confirmPassword: String, password: String)
}