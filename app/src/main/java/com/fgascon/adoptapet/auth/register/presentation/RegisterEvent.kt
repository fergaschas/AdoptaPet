package com.fgascon.adoptapet.auth.register.presentation

sealed class RegisterEvent {
    data class ChangeEmail(val email: String): RegisterEvent()
    data class ChangePassword(val password1: String): RegisterEvent()
    data class ChangePassword2(val password2: String): RegisterEvent()
    data object Register: RegisterEvent()
}
