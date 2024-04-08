package com.fgascon.adoptapet.auth.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fgascon.adoptapet.auth.login.domain.LoginUseCase
import com.fgascon.adoptapet.auth.login.presentation.LoginEvent.ChangeEmail
import com.fgascon.adoptapet.auth.login.presentation.LoginEvent.ChangePassword
import com.fgascon.adoptapet.auth.login.presentation.LoginEvent.Login
import com.fgascon.adoptapet.core.models.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase = LoginUseCase()
) : ViewModel() {
    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state

    fun onEvent(event: LoginEvent) {
        when (event) {
            is ChangeEmail -> changeEmail(event.email)

            is ChangePassword -> changePassword(event.password)

            Login -> login()
        }
    }

    private fun login() {
        _state.update {
            it.copy(isLoading = true)
        }
        viewModelScope.launch {
            val loginResult = loginUseCase.login(
                _state.value.email,
                _state.value.password
            )
            when (loginResult) {
                is Result.Success -> {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            isUserLoggedIn = true
                        )
                    }
                }

                is Result.Error -> {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = loginResult.error
                        )
                    }
                }
            }
        }

    }

    private fun changePassword(password: String) {
        _state.update {
            it.copy(password = password)
        }
    }

    private fun changeEmail(email: String) {
        _state.update {
            it.copy(email = email)
        }
    }
}