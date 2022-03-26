package com.example.domain.repositories

import com.example.domain.entities.UserDataForTape

interface TapeRepo {
    suspend fun getDataUsersNetworkForTape(): List<UserDataForTape>
}
