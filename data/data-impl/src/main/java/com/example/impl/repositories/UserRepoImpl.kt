package com.example.impl.repositories

import com.example.domain.entities.UserDataForTape
import com.example.domain.repositories.UserRepo
import com.example.impl.mapping.DataMapper
import com.example.impl.storage.AppDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepoImpl @Inject constructor(
    private val database: AppDatabase,
    private val mapper: DataMapper
) : UserRepo {

    override suspend fun getDataUser(id: Long): Flow<UserDataForTape> {
        return database.userDao().getUser(id).map { user ->
            mapper.mapPerson(user)
        }
    }
}
