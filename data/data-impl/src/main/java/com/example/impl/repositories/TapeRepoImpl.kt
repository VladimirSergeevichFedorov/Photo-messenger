package com.example.impl.repositories

import com.example.domain.entities.UserDataForTape
import com.example.domain.repositories.TapeRepo
import com.example.feature_tape_impl.retrofit.UserData
import com.example.impl.mapping.mapToGetUserDataForTape
import com.example.impl.retrofit.NetworkController
import com.example.impl.storage.AppDatabase
import javax.inject.Inject

class TapeRepoImpl @Inject constructor(
    private val networkController: NetworkController,
    private val database: AppDatabase
) :
    TapeRepo {
    override suspend fun getDataUsersNetworkForTape(): List<UserDataForTape> {
        return networkController.getUserList().data.map { userTapeData ->
            mapToGetUserDataForTape(
                UserData(
                    userTapeData.id,
                    userTapeData.email,
                    userTapeData.firstName,
                    userTapeData.lastName,
                    userTapeData.avatar
                )
            )
        }
    }
}
