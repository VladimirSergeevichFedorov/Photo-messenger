package com.example.domain.repositories

import com.example.common.utils.ConfirmPassword
import com.example.common.utils.PasswordString
import com.example.common.utils.UserNameString

interface RegisterRepo {
    suspend fun saveLogin(login: UserNameString)
    suspend fun savePinCode(confirmPassword: ConfirmPassword, password: PasswordString)
}
