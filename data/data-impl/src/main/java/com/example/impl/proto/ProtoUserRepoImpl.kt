package com.example.impl.proto

import androidx.datastore.core.DataStore
import com.example.domain.usecase.ProtoUserRepo
import com.example.domain.entity.UserPersonalData
import com.example.common.utils.EmailString
import com.example.common.utils.MobileNumberString
import com.example.common.utils.PasswordString
import com.example.common.utils.UserNameString
import com.example.photoch.UserStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProtoUserRepoImpl @Inject constructor(
    private val protoDataStore: DataStore<UserStore>
) : ProtoUserRepo {

    override suspend fun saveUserPasswordState(state: PasswordString) {
        protoDataStore.updateData { storePassword ->
            storePassword.toBuilder()
                .setPassword(state)
                .build()
        }
    }

    override suspend fun saveUserNameState(state: UserNameString) {
        protoDataStore.updateData { store ->
            store.toBuilder()
                .setUserName(state)
                .build()
        }
    }

    override suspend fun saveEmailState(state: EmailString) {
        protoDataStore.updateData { store ->
            store.toBuilder()
                .setEmail(state)
                .build()
        }
    }

    override suspend fun saveMobileNumberState(state: MobileNumberString) {
        protoDataStore.updateData { store ->
            store.toBuilder()
                .setMobileNumber(state)
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

                UserPersonalData(
                    protoBuilder.password,
                    protoBuilder.userName,
                    protoBuilder.email,
                    protoBuilder.mobileNumber
                )
            }
    }
}
