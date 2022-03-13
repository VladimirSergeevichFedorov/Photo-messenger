package com.example.feature_login.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.domain.ProtoUserRepo
import com.example.domain.utils.*
import com.example.impl.utils.CheckStatus
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginRegisterScreenViewModel @Inject constructor(
    private val protoUserRepo: ProtoUserRepo
) : ViewModel() {

    fun checkPassword(
        password: PasswordString,
        login: UserNameString,
        email: EmailString,
        mobileNumber: MobileNumberString,
        confirmPassword: PasswordString
    ): CheckStatus {
        return if (password.getSHA512() == confirmPassword.getSHA512()) {
            viewModelScope.launch {
                protoUserRepo.apply {
                    saveUserNameState(login)
                    saveUserPasswordState(password.getSHA512())
                    saveEmailState(email)
                    saveMobileNumberState(mobileNumber)
                }
            }
            CheckStatus.SUCCES
        } else {
            CheckStatus.UNSUCCES
        }
    }
}
