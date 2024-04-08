package com.fgascon.adoptapet.auth.login.presentation

import com.fgascon.adoptapet.core.models.Error


data class LoginState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: Error? = null,
    val isUserLoggedIn: Boolean = false
)
