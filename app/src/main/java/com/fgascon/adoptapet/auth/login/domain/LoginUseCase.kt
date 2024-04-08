package com.fgascon.adoptapet.auth.login.domain

import com.fgascon.adoptapet.auth.core.data.FirebaseAuthApi
import com.fgascon.adoptapet.auth.login.data.LoginRepositoryImpl
import com.fgascon.adoptapet.auth.core.domain.AuthError
import com.fgascon.adoptapet.core.models.Result

class LoginUseCase(
    private val loginRepository: LoginRepository = LoginRepositoryImpl(FirebaseAuthApi())
) {

    suspend fun login(email: String, password: String) : Result<Unit, AuthError> {
        return loginRepository.login(email, password)
    }
}
