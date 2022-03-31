package com.example.domain.repositories

import com.example.domain.entities.UserDataForTape

interface TapeRepo {
    suspend fun getDataUsersForTapeFromNetwork(): List<UserDataForTape>
    suspend fun getDataUsersForTapeFromStorage(): List<UserDataForTape>
}
