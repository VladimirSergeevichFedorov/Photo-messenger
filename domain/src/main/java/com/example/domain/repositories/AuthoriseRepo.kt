package com.example.domain.repositories

import com.example.common.utils.EnterPasswordString
import com.example.common.utils.EnterUserNameString
import com.example.common.utils.PasswordString
import com.example.common.utils.UserNameString

interface AuthoriseRepo {
    suspend fun checkLogin(enteredLogin: EnterUserNameString, login: UserNameString)
    suspend fun checkPinCode(enteredPassword: EnterPasswordString, password: PasswordString)
}
