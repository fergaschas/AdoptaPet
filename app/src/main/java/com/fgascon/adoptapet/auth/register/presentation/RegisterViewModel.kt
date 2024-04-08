package com.fgascon.adoptapet.auth.register.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fgascon.adoptapet.auth.register.domain.RegisterUseCase
import com.fgascon.adoptapet.core.models.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val registerUseCase: RegisterUseCase = RegisterUseCase()
) : ViewModel() {
    private val _state = MutableStateFlow(RegisterState())
    val state: StateFlow<RegisterState> = _state


    fun onEvent(event: RegisterEvent) {
        when (event) {
            is RegisterEvent.ChangeEmail -> {
                changeEmail(event.email)
            }

            is RegisterEvent.ChangePassword -> {
                changePassword1(event.password1)
            }

            is RegisterEvent.ChangePassword2 -> {
                changePassword2(event.password2)
            }

            RegisterEvent.Register -> register()
        }
    }

    private fun register() {
        _state.update {
            it.copy(isLoading = true)
        }
        viewModelScope.launch {
            val result = registerUseCase.register(_state.value.email, _state.value.password)
            when (result) {
                is Result.Success -> {
                    _state.update {
                        it.copy(
                            isUserRegistered = true,
                            isLoading = false
                        )
                    }
                }

                is Result.Error -> {
                    _state.update {
                        it.copy(
                            error = result.error,
                            isLoading = false
                        )
                    }
                }
            }
        }
    }


    private fun changePassword1(password: String) {
        _state.update {
            it.copy(password = password)
        }
    }

    private fun changePassword2(password2: String) {
        _state.update {
            it.copy(password2 = password2)
        }
    }

    private fun changeEmail(email: String) {
        _state.update {
            it.copy(email = email)
        }
    }
}
