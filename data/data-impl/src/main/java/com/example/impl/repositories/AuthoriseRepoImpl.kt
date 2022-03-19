package com.example.impl.repositories

import com.example.domain.usecase.AuthoriseRepo
import com.example.domain.utils.AuthException
import com.example.common.utils.EnterUserNameString
import com.example.common.utils.PasswordString
import com.example.common.utils.UserNameString
import com.example.common.utils.getSHA512
import javax.inject.Inject

class AuthoriseRepoImpl @Inject constructor() : AuthoriseRepo {
    override suspend fun checkLogin(enteredLogin: EnterUserNameString, login: UserNameString) {
        if (enteredLogin != login || enteredLogin.isEmpty()) throw AuthException()
    }

    override suspend fun checkPinCode(enteredPassword: PasswordString, password: String) {
        if (enteredPassword.getSHA512() != password || enteredPassword.isEmpty()) throw AuthException()
    }
}
