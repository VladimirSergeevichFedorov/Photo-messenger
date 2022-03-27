package com.example.impl.repositories

import com.example.common.utils.orZero
import com.example.domain.entities.UserDataForTape
import com.example.domain.repositories.TapeRepo
import com.example.feature_tape_impl.retrofit.UserData
import com.example.impl.mapping.mapToGetUserDataForTape
import com.example.impl.mapping.mapToGetUserForTape
import com.example.impl.retrofit.NetworkController
import com.example.impl.storage.AppDatabase
import javax.inject.Inject

class TapeRepoImpl @Inject constructor(
    private val networkController: NetworkController,
    private val database: AppDatabase
) : TapeRepo {

    override suspend fun getDataUsersForTape(): List<UserDataForTape> {
        networkController.getUserList().body()?.data?.let {
            database.userDao().insertAll(
                networkController.getUserList().body()?.data.orEmpty()
                    .map { userTapeData ->
                        mapToGetUserForTape(
                            UserData(
                                userTapeData.id.orZero(),
                                userTapeData.email.orEmpty(),
                                userTapeData.firstName.orEmpty(),
                                userTapeData.lastName.orEmpty(),
                                userTapeData.avatar.orEmpty()
                            )
                        )
                    }
            )
        }
        return database.userDao().getAll().map { userTapeData ->
            mapToGetUserDataForTape(
                UserData(
                    userTapeData.id.orZero(),
                    userTapeData.email.orEmpty(),
                    userTapeData.firstName.orEmpty(),
                    userTapeData.lastName.orEmpty(),
                    userTapeData.avatar.orEmpty()
                )
            )
        }
    }
}
