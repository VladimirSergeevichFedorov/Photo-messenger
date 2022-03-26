package com.example.domain.usecase

import com.example.domain.repositories.TapeRepo

class GetTapeUsersUseCase(private val tapeRepo: TapeRepo) {
    suspend fun getUsers() = tapeRepo.getDataUsersNetworkForTape()
}