package com.fgascon.adoptapet.auth.register.domain

import com.fgascon.adoptapet.auth.core.data.FirebaseAuthApi
import com.fgascon.adoptapet.auth.register.data.RegisterRepositoryImpl
import com.fgascon.adoptapet.auth.core.domain.AuthError
import com.fgascon.adoptapet.core.models.Result

class RegisterUseCase(
    private val registerRepository: RegisterRepository = RegisterRepositoryImpl(
        firebaseAuthApi = FirebaseAuthApi()
    )
) {

    suspend fun register(email: String, password: String): Result<Unit, AuthError> {
        return registerRepository.register(email, password)
    }
}
