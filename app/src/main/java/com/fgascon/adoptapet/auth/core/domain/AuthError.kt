package com.fgascon.adoptapet.auth.core.domain

import com.fgascon.adoptapet.core.models.Error

enum class AuthError : Error {
    INVALID_CREDENTIALS,
    USER_NOT_FOUND,
}