package com.example.impl.usecase

import com.example.domain.utils.EnterUserNameString
import com.example.domain.utils.PasswordString
import com.example.domain.utils.UserNameString
import com.example.domain.utils.getSHA512
import javax.inject.Inject

class AuthoriseRepoImpl @Inject constructor() : AuthoriseRepo {
    override suspend fun checkLoginCode(enteredLogin: EnterUserNameString, login: UserNameString) {
        if (enteredLogin != login) throw AuthException()
    }

    override suspend fun checkPinCode(enteredPassword: PasswordString, password: String) {
        if (enteredPassword.getSHA512() != password) throw AuthException()
    }
}

class AuthException : Exception()
