package com.example.domain.repositories

import com.example.domain.entities.UserDataForTape
import kotlinx.coroutines.flow.Flow

interface TapeRepo {
    suspend fun getDataUsersForTapeFromNetwork(): List<UserDataForTape>
    suspend fun getDataUsersForTapeFromStorage(): Flow<List<UserDataForTape>>
}
