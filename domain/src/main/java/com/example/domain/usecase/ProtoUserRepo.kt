package com.example.domain.usecase

import com.example.domain.entity.UserPersonalData
import kotlinx.coroutines.flow.Flow

interface ProtoUserRepo {
    suspend fun saveUserPasswordState(state: String)
    suspend fun saveUserNameState(state: String)
    suspend fun saveEmailState(state: String)
    suspend fun saveMobileNumberState(state: String)
    suspend fun getUserDataState(): Flow<UserPersonalData>
}
