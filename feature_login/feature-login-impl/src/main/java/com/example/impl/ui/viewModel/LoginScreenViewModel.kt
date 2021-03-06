package com.example.feature_login.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.utils.PasswordString
import com.example.common.utils.UserNameString
import com.example.domain.repositories.AuthoriseRepo
import com.example.domain.repositories.ProtoUserRepo
import com.example.domain.usecase.GetUserDataUseCase
import com.example.domain.utils.AuthException
import com.example.impl.utils.CheckStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginScreenViewModel @Inject constructor(
    private val getUserDataUseCase: GetUserDataUseCase,
    private val authoriseRepo: AuthoriseRepo
) : ViewModel() {

    private var _fieldsScreenState: MutableStateFlow<CheckStatus> =
        MutableStateFlow(CheckStatus.EMPTY)
    val fieldsScreenState get(): StateFlow<CheckStatus> = _fieldsScreenState

    fun checkLoginAndPassword(
        enteredPassword: PasswordString,
        enteredLogin: UserNameString
    ) {
        viewModelScope.launch {
            getUserDataUseCase.getUserData().collect { user ->
                withContext(Dispatchers.IO) {
                    try {
                        authoriseRepo.checkLogin(
                            enteredLogin = enteredLogin,
                            login = user.userName
                        )
                        authoriseRepo.checkPinCode(
                            enteredPassword = enteredPassword,
                            password = user.password
                        )
                        _fieldsScreenState.emit(CheckStatus.SUCCES)
                    } catch (e: AuthException) {
                        _fieldsScreenState.emit(CheckStatus.UNSUCCES)
                    }
                }
            }
        }
    }
}
