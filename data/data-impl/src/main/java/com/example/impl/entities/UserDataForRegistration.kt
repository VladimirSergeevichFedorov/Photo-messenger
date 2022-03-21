package com.example.impl.entities

data class UserDataForRegistration(
    val password: String,
    val userName: String,
    val email: String?,
    val mobileNumber: String
)
