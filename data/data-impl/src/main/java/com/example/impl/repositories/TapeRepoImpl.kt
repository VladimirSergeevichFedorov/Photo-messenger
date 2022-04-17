package com.example.impl.repositories

import com.example.common.utils.orZero
import com.example.domain.entities.UserDataForTape
import com.example.domain.repositories.TapeRepo
import com.example.feature_tape_impl.retrofit.UserData
import com.example.impl.mapping.DataMapper
import com.example.impl.retrofit.NetworkController
import com.example.impl.storage.AppDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TapeRepoImpl @Inject constructor(
    private val networkController: NetworkController,
    private val database: AppDatabase,
    private val mapper: DataMapper
) : TapeRepo {

    override suspend fun getDataUsersForTapeFromNetwork():
        List<UserDataForTape> {
        fromNetworkToStorage()
        return networkController.getUserList().body()?.data.orEmpty().map { userTapeData ->
            mapper.mapToGetUserDataForTape(
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

    override suspend fun getDataUsersForTapeFromStorage(): Flow<List<UserDataForTape>> =
        database.userDao().getAll().map {
            it.map { userTapeData ->
                mapper.mapToGetUserDataForTape(
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

    private suspend fun fromNetworkToStorage() {
        networkController.getUserList().body()?.data?.let {
            database.userDao().insertAll(
                networkController.getUserList().body()?.data.orEmpty()
                    .map { userTapeData ->
                        mapper.mapToGetUserForTape(
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
    }
}
