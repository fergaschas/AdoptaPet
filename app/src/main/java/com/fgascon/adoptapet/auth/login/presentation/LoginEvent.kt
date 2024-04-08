package com.fgascon.adoptapet.auth.login.presentation

sealed class LoginEvent {
    data class ChangeEmail(val email: String) : LoginEvent()
    data class ChangePassword(val password: String) : LoginEvent()
    data object Login : LoginEvent()
}