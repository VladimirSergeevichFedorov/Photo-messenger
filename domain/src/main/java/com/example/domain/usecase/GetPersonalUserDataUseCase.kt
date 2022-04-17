package com.example.domain.usecase

import com.example.domain.repositories.UserRepo

class GetPersonalUserDataUseCase(private val userRepo: UserRepo) {
    suspend fun getUserStorage(id: Long) = userRepo.getDataUser(id)
}