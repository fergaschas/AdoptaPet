package com.fgascon.adoptapet.auth.register.presentation

import com.fgascon.adoptapet.core.models.Error

data class RegisterState(
    val email: String = "",
    val password: String = "",
    val password2: String = "",
    val isLoading: Boolean = false,
    val isUserRegistered: Boolean = false,
    val error: Error? = null,
)
