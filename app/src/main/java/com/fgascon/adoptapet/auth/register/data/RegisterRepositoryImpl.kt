package com.fgascon.adoptapet.auth.register.data

import com.fgascon.adoptapet.auth.core.data.FirebaseAuthApi
import com.fgascon.adoptapet.auth.core.domain.AuthError
import com.fgascon.adoptapet.auth.register.domain.RegisterRepository
import com.fgascon.adoptapet.core.models.Result

class RegisterRepositoryImpl(
    private val firebaseAuthApi: FirebaseAuthApi
) : RegisterRepository {
    override suspend fun register(email: String, password: String): Result<Unit, AuthError> {
        val result = firebaseAuthApi.register(email, password)
        return if (result is Result.Success) {
            Result.Success(Unit)
        } else {
            Result.Error(AuthError.USER_NOT_FOUND)
        }

    }

}
