package com.fgascon.adoptapet.auth.core.data

import com.fgascon.adoptapet.auth.core.domain.AuthError
import com.fgascon.adoptapet.core.models.Result
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import kotlinx.coroutines.tasks.await

class FirebaseAuthApi {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    suspend fun login(email: String, password: String): Result<AuthResult, AuthError> {
        return try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            Result.Success(result)
        } catch (e: FirebaseAuthException) {
            when (e) {
                is FirebaseAuthInvalidCredentialsException -> Result.Error(AuthError.INVALID_CREDENTIALS)
                else -> Result.Error(AuthError.USER_NOT_FOUND)
            }
        }
    }

    suspend fun register(email: String, password: String): Result<AuthResult, AuthError> {
        return try {
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            Result.Success(result)
        } catch (e: FirebaseAuthException) {
            when (e) {
                is FirebaseAuthInvalidCredentialsException -> Result.Error(AuthError.INVALID_CREDENTIALS)
                else -> Result.Error(AuthError.USER_NOT_FOUND)
            }
        }
    }
}
