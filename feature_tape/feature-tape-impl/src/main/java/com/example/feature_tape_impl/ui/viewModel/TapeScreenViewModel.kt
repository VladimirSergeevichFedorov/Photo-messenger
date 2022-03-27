package com.example.feature_tape_impl.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.UserDataForTape
import com.example.domain.usecase.GetTapeUsersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class TapeScreenViewModel @Inject constructor(
    private val getTapeUsersUseCase: GetTapeUsersUseCase
) : ViewModel() {

    private val _networkResultStateFlow = MutableStateFlow<List<UserDataForTape>>(emptyList())
    val networkResultStateFlow: StateFlow<List<UserDataForTape>>
        get() = _networkResultStateFlow

    fun loadUsersData() {
        viewModelScope.launch {
            _networkResultStateFlow.emit(getTapeUsersUseCase.getUsersStorage())
        }
    }
}
