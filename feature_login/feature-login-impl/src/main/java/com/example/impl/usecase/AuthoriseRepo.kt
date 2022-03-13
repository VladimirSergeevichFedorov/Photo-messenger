package com.example.impl.usecase

import com.example.domain.utils.EnterPasswordString
import com.example.domain.utils.EnterUserNameString
import com.example.domain.utils.PasswordString
import com.example.domain.utils.UserNameString

interface AuthoriseRepo {
    suspend fun checkLoginCode(enteredLogin: EnterUserNameString, login: UserNameString)
    suspend fun checkPinCode(enteredPassword: EnterPasswordString, password: PasswordString)
}
