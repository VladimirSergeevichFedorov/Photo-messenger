package com.example.domain.usecase

interface RegisterRepo {
    suspend fun saveLogin(login: String)
    suspend fun savePinCode(confirmPassword: String, password: String)
}
