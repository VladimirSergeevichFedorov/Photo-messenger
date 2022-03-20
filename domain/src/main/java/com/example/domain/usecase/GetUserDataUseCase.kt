package com.example.domain.usecase

import com.example.domain.repositories.ProtoUserRepo

class GetUserDataUseCase(private val protoUserRepo: ProtoUserRepo) {

    suspend fun getUserData() = protoUserRepo.getUserDataState()
}
