package com.example.feature_login.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.utils.ConfirmPassword
import com.example.common.utils.EmailString
import com.example.common.utils.MobileNumberString
import com.example.common.utils.PasswordString
import com.example.common.utils.UserNameString
import com.example.common.utils.getSHA512
import com.example.domain.entities.UserPersonalData
import com.example.domain.repositories.RegisterRepo
import com.example.domain.usecase.SaveUserDataUseCase
import com.example.domain.utils.RegisterException
import com.example.impl.utils.CheckStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginRegisterScreenViewModel @Inject constructor(
    private val saveUserDataUseCase: SaveUserDataUseCase,
    private val registerRepo: RegisterRepo
) : ViewModel() {

    private var _fieldsScreenStateRegister: MutableStateFlow<CheckStatus> =
        MutableStateFlow(CheckStatus.EMPTY)
    val fieldsScreenStateRegister get(): StateFlow<CheckStatus> = _fieldsScreenStateRegister

    fun checkRegisterData(
        password: PasswordString,
        login: UserNameString,
        email: EmailString,
        mobileNumber: MobileNumberString,
        confirmPassword: ConfirmPassword
    ) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    registerRepo.saveLogin(login = login)
                    registerRepo.savePinCode(
                        confirmPassword = confirmPassword,
                        password = password
                    )
                    saveUserDataUseCase.saveUserDataState(
                        userPersonalData = UserPersonalData(
                            password = password.getSHA512(),
                            userName = login,
                            mobileNumber = mobileNumber,
                            email = email
                        )
                    )
                    _fieldsScreenStateRegister.emit(CheckStatus.SUCCES)
                } catch (e: RegisterException) {
                    _fieldsScreenStateRegister.emit(CheckStatus.UNSUCCES)
                }
            }
        }
    }
}
