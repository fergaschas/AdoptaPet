package com.fgascon.adoptapet.auth.login.domain

import com.fgascon.adoptapet.auth.core.domain.AuthError
import com.fgascon.adoptapet.core.models.Result

interface LoginRepository {
    suspend fun login(email: String, password: String): Result<Unit, AuthError>

}
