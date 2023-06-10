package com.github.aptemkov.onlinestore.data.repository

import android.util.Log
import com.github.aptemkov.onlinestore.domain.models.Response
import com.github.aptemkov.onlinestore.domain.models.Response.Success
import com.github.aptemkov.onlinestore.domain.models.Response.Failure
import com.github.aptemkov.onlinestore.domain.models.Response.Loading
import com.github.aptemkov.onlinestore.domain.repository.AuthorizationRepository
import com.github.aptemkov.onlinestore.domain.repository.ReloadUserResponse
import com.github.aptemkov.onlinestore.domain.repository.RevokeAccessResponse
import com.github.aptemkov.onlinestore.domain.repository.SendEmailVerificationResponse
import com.github.aptemkov.onlinestore.domain.repository.SendPasswordResetEmailResponse
import com.github.aptemkov.onlinestore.domain.repository.SignInResponse
import com.github.aptemkov.onlinestore.domain.repository.SignUpResponse
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthorizationRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth
) : AuthorizationRepository {
    override val currentUser get() = auth.currentUser

    override suspend fun firebaseSignUpWithEmailAndPassword(
        email: String, password: String
    ): SignUpResponse {
        return try {
            auth.createUserWithEmailAndPassword(email, password).await()
            Log.i("Auth", "success")
            Success(true)
        } catch (e: Exception) {
            Log.i("Auth", "failure ${e.message}")
            Failure(e)
        }
    }

    override suspend fun sendEmailVerification(): SendEmailVerificationResponse {
        return try {
            auth.currentUser?.sendEmailVerification()?.await()
            Success(true)
        } catch (e: Exception) {
            Failure(e)
        }
    }

    override suspend fun firebaseSignInWithEmailAndPassword(
        email: String, password: String
    ): SignInResponse {
        return try {
            auth.signInWithEmailAndPassword(email, password).await()
            Success(true)
        } catch (e: Exception) {
            Failure(e)
        }
    }

    override suspend fun reloadFirebaseUser(): ReloadUserResponse {
        return try {
            auth.currentUser?.reload()?.await()
            Success(true)
        } catch (e: Exception) {
            Failure(e)
        }
    }

    override suspend fun sendPasswordResetEmail(email: String): SendPasswordResetEmailResponse {
        return try {
            auth.sendPasswordResetEmail(email).await()
            Success(true)
        } catch (e: Exception) {
            Failure(e)
        }
    }

    override fun signOut() = auth.signOut()

    override suspend fun revokeAccess(): RevokeAccessResponse {
        return try {
            auth.currentUser?.delete()?.await()
            Success(true)
        } catch (e: Exception) {
            Failure(e)
        }
    }

    override fun getAuthState(viewModelScope: CoroutineScope) = callbackFlow {
        val authStateListener = FirebaseAuth.AuthStateListener { auth ->
            trySend(auth.currentUser == null)
        }
        auth.addAuthStateListener(authStateListener)
        awaitClose {
            auth.removeAuthStateListener(authStateListener)
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), auth.currentUser == null)
}