package com.raana.composeSample.ui.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raana.composeSample.domain.repository.user.model.User
import com.raana.composeSample.domain.usecase.user.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val getUsersUseCase: GetUsersUseCase) :
    ViewModel() {

    private val _state = MutableStateFlow<UserScreenState>(UserScreenState.Initial)
    val state = _state.asStateFlow()

    init {
        getUsers()
    }

    fun getUsers() {
        viewModelScope.launch {
            _state.update { UserScreenState.Loading }
            viewModelScope.launch {
                getUsersUseCase.invoke().fold(onSuccess = { res ->
                    _state.update { UserScreenState.Success(res) }
                },
                    onFailure = { throwable ->
                        _state.update { UserScreenState.Error(throwable) }
                    })
            }
        }
    }

    sealed class UserScreenState {
        object Initial : UserScreenState()
        object Loading : UserScreenState()
        class Error(val throwable: Throwable) : UserScreenState()
        class Success(val users: List<User>) : UserScreenState()
    }
}

