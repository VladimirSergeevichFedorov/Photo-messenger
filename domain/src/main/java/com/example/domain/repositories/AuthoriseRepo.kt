package com.example.domain.repositories

interface AuthoriseRepo {
    suspend fun checkLogin(enteredLogin: String, login: String)
    suspend fun checkPinCode(enteredPassword: String, password: String)
}
