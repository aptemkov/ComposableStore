package com.github.aptemkov.onlinestore.app.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.aptemkov.onlinestore.domain.repository.AuthorizationRepository
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: AuthorizationRepository,
    private val firebaseAuth: FirebaseAuth,
): ViewModel() {
    init {
        getAuthState()
    }

    fun getAuthState() = repo.getAuthState(viewModelScope)



    val isEmailVerified get() = firebaseAuth.currentUser?.isEmailVerified ?: false

    fun sendEmailVerification() = viewModelScope.launch {
        if(!isEmailVerified) {
            repo.sendEmailVerification()
        }
    }
}