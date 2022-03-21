package com.example.domain.usecase

import com.example.domain.entities.UserPersonalData
import com.example.domain.repositories.ProtoUserRepo

class SaveUserDataUseCase(private val protoUserRepo: ProtoUserRepo) {

    suspend fun saveUserDataState(userPersonalData: UserPersonalData) = protoUserRepo.saveUserDataState(userPersonalData)
}
