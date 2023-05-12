package com.github.aptemkov.onlinestore.app.di

import com.github.aptemkov.onlinestore.data.AuthorizationRepositoryImpl
import com.github.aptemkov.onlinestore.domain.repository.AuthorizationRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideAuthRepositoryImpl(): AuthorizationRepository {
        return AuthorizationRepositoryImpl(Firebase.auth)
    }

}