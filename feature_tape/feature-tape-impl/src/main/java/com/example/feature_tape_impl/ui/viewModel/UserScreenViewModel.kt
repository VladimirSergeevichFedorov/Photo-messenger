package com.example.feature_tape_impl.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.utils.orZero
import com.example.domain.entities.UserDataForTape
import com.example.domain.usecase.GetPersonalUserDataUseCase
import com.example.feature_tape_impl.di.user.UserId
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.flow.collect

class UserScreenViewModel @Inject constructor(
    private val getPersonalUserDataUseCase: GetPersonalUserDataUseCase,
    @UserId private val userId: String?
) : ViewModel() {

    private val _getUserStateFlow = MutableStateFlow<UserDataForTape?>(null)
    val getUserStateFlow: StateFlow<UserDataForTape?>
        get() = _getUserStateFlow

    fun get() {
        val parseUserId = userId?.toLongOrNull()
        viewModelScope.launch {
            parseUserId?.let { id ->
                getPersonalUserDataUseCase.getUserStorage(id).collect { userData ->
                    _getUserStateFlow.emit(userData)
                }
            }
        }
    }
}
