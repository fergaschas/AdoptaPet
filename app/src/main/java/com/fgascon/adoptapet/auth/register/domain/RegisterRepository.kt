package com.fgascon.adoptapet.auth.register.domain

import com.fgascon.adoptapet.auth.core.domain.AuthError
import com.fgascon.adoptapet.core.models.Result

interface RegisterRepository {
    suspend fun register(email: String, password: String): Result<Unit, AuthError>
}
