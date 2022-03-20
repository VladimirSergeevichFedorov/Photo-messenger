package com.example.domain.repositories

import com.example.domain.entitys.UserPersonalData
import kotlinx.coroutines.flow.Flow

interface ProtoUserRepo {
    suspend fun saveUserPasswordState(state: String)
    suspend fun saveUserNameState(state: String)
    suspend fun saveEmailState(state: String)
    suspend fun saveMobileNumberState(state: String)
    suspend fun getUserDataState(): Flow<UserPersonalData>
}
