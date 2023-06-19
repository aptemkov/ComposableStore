package com.github.aptemkov.onlinestore.app.presentation.authorization

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.aptemkov.onlinestore.domain.models.Response.Success
import com.github.aptemkov.onlinestore.domain.models.Response.Failure
import com.github.aptemkov.onlinestore.domain.models.Response.Loading
import com.github.aptemkov.onlinestore.domain.repository.AuthorizationRepository
import com.github.aptemkov.onlinestore.domain.repository.SendEmailVerificationResponse
import com.github.aptemkov.onlinestore.domain.repository.SignInResponse
import com.github.aptemkov.onlinestore.domain.repository.SignUpResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor(
    private val repository: AuthorizationRepository
) : ViewModel() {

    var signUpResponse by mutableStateOf<SignUpResponse>(Success(false))
        private set
    var sendEmailVerificationResponse by mutableStateOf<SendEmailVerificationResponse>(Success(false))
        private set
    var signInResponse by mutableStateOf<SignInResponse>(Success(false))
        private set

    fun signInWithEmailAndPassword(email: String, password: String) = viewModelScope.launch {
        signInResponse = Loading
        signInResponse = repository.firebaseSignInWithEmailAndPassword(email, password)
    }
    fun signUpWithEmailAndPassword(email: String, password: String) = viewModelScope.launch {
        signUpResponse = Loading
        signUpResponse = repository.firebaseSignUpWithEmailAndPassword(email, password)
    }

    /*fun sendEmailVerification() = viewModelScope.launch {
        if(repository.currentUser?.isEmailVerified == false) {
            sendEmailVerificationResponse = Loading
            sendEmailVerificationResponse = repository.sendEmailVerification()
        }
    }

    val isEmailVerified get() = repository.currentUser?.isEmailVerified ?: false
*/
}