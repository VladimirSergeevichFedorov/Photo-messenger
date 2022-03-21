package com.example.domain.entities

data class UserPersonalData(
    val password: String,
    val userName: String,
    val email: String?,
    val mobileNumber: String
)
