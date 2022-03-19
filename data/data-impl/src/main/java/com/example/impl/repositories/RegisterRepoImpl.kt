package com.example.impl.repositories

import com.example.domain.usecase.RegisterRepo
import com.example.common.utils.ConfirmPassword
import com.example.common.utils.PasswordString
import com.example.domain.utils.RegisterException
import com.example.common.utils.UserNameString
import com.example.common.utils.getSHA512
import javax.inject.Inject

class RegisterRepoImpl @Inject constructor() : RegisterRepo {
    override suspend fun saveLogin(login: UserNameString) {
        if (login.isEmpty()) throw RegisterException()
    }

    override suspend fun savePinCode(confirmPassword: ConfirmPassword, password: PasswordString) {
        if (password.getSHA512() != confirmPassword.getSHA512() || password.isEmpty() || confirmPassword.isEmpty()) throw RegisterException()
    }
}


