package com.example.domain.repositories

import com.example.domain.entities.UserPersonalData
import kotlinx.coroutines.flow.Flow

interface ProtoUserRepo {
    suspend fun saveUserDataState(userPersonalData: UserPersonalData)
    suspend fun getUserDataState(): Flow<UserPersonalData>
}
