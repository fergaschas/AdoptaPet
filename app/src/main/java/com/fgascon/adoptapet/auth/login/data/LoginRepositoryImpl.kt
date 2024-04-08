package com.fgascon.adoptapet.auth.login.data

import com.fgascon.adoptapet.auth.core.data.FirebaseAuthApi
import com.fgascon.adoptapet.auth.core.domain.AuthError
import com.fgascon.adoptapet.auth.login.domain.LoginRepository
import com.fgascon.adoptapet.core.models.Result

class LoginRepositoryImpl(
    private val firebaseAuthentication: FirebaseAuthApi
) : LoginRepository {
    override suspend fun login(email: String, password: String): Result<Unit, AuthError> {
        val result = firebaseAuthentication.login(email, password)
        return when (result) {
            is Result.Success -> Result.Success(Unit)
            is Result.Error -> Result.Error(result.error)
        }
    }
}