package com.example.domain.domain

import com.example.domain.entity.UserPersonalData
import com.example.domain.utils.EmailString
import com.example.domain.utils.MobileNumberString
import com.example.domain.utils.PasswordString
import com.example.domain.utils.UserNameString
import kotlinx.coroutines.flow.Flow

interface ProtoUserRepo {
    suspend fun saveUserPasswordState(state: PasswordString)
    suspend fun saveUserNameState(state: UserNameString)
    suspend fun saveEmailState(state: EmailString)
    suspend fun saveMobileNumberState(state: MobileNumberString)
    suspend fun getUserDataState(): Flow<UserPersonalData>
}
