package com.github.aptemkov.onlinestore.app.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.aptemkov.onlinestore.domain.repository.AuthorizationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: AuthorizationRepository
): ViewModel() {
    init {
        getAuthState()
    }

    fun getAuthState() = repo.getAuthState(viewModelScope)



    val isEmailVerified get() = repo.currentUser?.isEmailVerified ?: false

    fun sendEmailVerification() = viewModelScope.launch {
        if(!isEmailVerified) {
            repo.sendEmailVerification()
        }
    }
}