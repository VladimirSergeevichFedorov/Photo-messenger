package com.example.feature_login.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.domain.ProtoUserRepo
import com.example.domain.utils.PasswordString
import com.example.domain.utils.UserNameString
import com.example.impl.usecase.AuthException
import com.example.impl.usecase.AuthoriseRepo
import com.example.impl.utils.CheckStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginScreenViewModel @Inject constructor(
    private val protoUserRepo: ProtoUserRepo,
    private val authoriseRepo: AuthoriseRepo
) : ViewModel() {

    private var _fieldsScreenState: MutableStateFlow<CheckStatus> =
        MutableStateFlow(CheckStatus.EMPTY)
    val fieldsScreenState get(): StateFlow<CheckStatus> = _fieldsScreenState

    fun checkPassword(
        enteredPassword: PasswordString,
        enteredLogin: UserNameString
    ) {
        viewModelScope.launch {
            protoUserRepo.getUserDataState().collect {
                withContext(Dispatchers.IO) {
                    try {
                        authoriseRepo.checkLoginCode(enteredLogin, it.userName.orEmpty())
                        authoriseRepo.checkPinCode(enteredPassword, it.password.orEmpty())
                        _fieldsScreenState.emit(CheckStatus.SUCCES)
                    } catch (e: AuthException) {
                        _fieldsScreenState.emit(CheckStatus.UNSUCCES)
                    }
                }
            }
        }
    }
}
