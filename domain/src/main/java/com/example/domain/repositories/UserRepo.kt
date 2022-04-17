package com.example.domain.repositories

import com.example.domain.entities.UserDataForTape
import kotlinx.coroutines.flow.Flow

interface UserRepo {
    suspend fun getDataUser(id: Long): Flow<UserDataForTape>
}