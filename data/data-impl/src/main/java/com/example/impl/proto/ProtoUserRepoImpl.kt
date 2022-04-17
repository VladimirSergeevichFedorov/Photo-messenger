package com.example.impl.proto

import androidx.datastore.core.DataStore
import com.example.domain.entities.UserPersonalData
import com.example.domain.repositories.ProtoUserRepo
import com.example.impl.entities.UserDataForRegistration
import com.example.impl.mapping.DataMapper
import com.example.photoch.UserStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProtoUserRepoImpl @Inject constructor(
    private val protoDataStore: DataStore<UserStore>,
    private val mapper: DataMapper
) : ProtoUserRepo {
    override suspend fun saveUserDataState(userPersonalData: UserPersonalData) {
        mapper.mapToSetUserData(userPersonalData)

        protoDataStore.updateData { storePassword ->
            storePassword.toBuilder()
                .setPassword(mapper.mapToSetUserData(userPersonalData).password)
                .build()
        }
        protoDataStore.updateData { storeUserName ->
            storeUserName.toBuilder()
                .setUserName(mapper.mapToSetUserData(userPersonalData).userName)
                .build()
        }
        protoDataStore.updateData { storeEmail ->
            storeEmail.toBuilder()
                .setEmail(mapper.mapToSetUserData(userPersonalData).email)
                .build()
        }
        protoDataStore.updateData { storeMobileNumber ->
            storeMobileNumber.toBuilder()
                .setMobileNumber(mapper.mapToSetUserData(userPersonalData).mobileNumber)
                .build()
        }
    }

    override suspend fun getUserDataState(): Flow<UserPersonalData> {
        return protoDataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(UserStore.getDefaultInstance())
                } else {
                    throw exception
                }
            }.map { protoBuilder ->

                mapper.mapToGetUserData(
                    UserDataForRegistration(
                        protoBuilder.password,
                        protoBuilder.userName,
                        protoBuilder.email,
                        protoBuilder.mobileNumber
                    )
                )
            }
    }
}
