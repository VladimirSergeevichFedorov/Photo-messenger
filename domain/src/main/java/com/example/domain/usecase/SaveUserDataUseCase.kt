package com.example.domain.usecase

import com.example.domain.repositories.ProtoUserRepo

class SaveUserDataUseCase(private val protoUserRepo: ProtoUserRepo) {

    suspend fun saveUserPassword(password: String) = protoUserRepo.saveUserPasswordState(password)

    suspend fun saveUserName(userName: String) = protoUserRepo.saveUserNameState(userName)

    suspend fun saveEmail(email: String) = protoUserRepo.saveEmailState(email)

    suspend fun saveMobileNumber(mobileNumber: String) = protoUserRepo.saveMobileNumberState(mobileNumber)
}
