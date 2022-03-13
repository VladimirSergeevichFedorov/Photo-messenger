package com.example.domain.entity

import com.example.domain.utils.EmailString
import com.example.domain.utils.MobileNumberString
import com.example.domain.utils.PasswordString
import com.example.domain.utils.UserNameString

data class UserPersonalData(
    val password: PasswordString?,
    val userName: UserNameString?,
    val email: EmailString?,
    val mobileNumber: MobileNumberString?
)
