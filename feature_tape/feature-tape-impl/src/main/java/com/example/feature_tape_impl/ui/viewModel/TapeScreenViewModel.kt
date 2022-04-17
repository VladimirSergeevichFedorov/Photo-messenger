package com.example.feature_tape_impl.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.UserDataForTape
import com.example.domain.usecase.GetTapeUsersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class TapeScreenViewModel @Inject constructor(
    private val getTapeUsersUseCase: GetTapeUsersUseCase
) : ViewModel() {

    private val _usersResultStateFlow = MutableStateFlow<List<UserDataForTape>>(emptyList())
    val usersResultStateFlow: StateFlow<List<UserDataForTape>>
        get() = _usersResultStateFlow

    fun loadUsersData() {
        viewModelScope.launch {
            try {
                _usersResultStateFlow.emit(getTapeUsersUseCase.getUsersNetwork())
            } catch (e: Exception) {
                getTapeUsersUseCase.getUsersStorage().collect { userDataFromStorage ->
                    _usersResultStateFlow.emit(userDataFromStorage)
                }
            }
        }
    }
}
