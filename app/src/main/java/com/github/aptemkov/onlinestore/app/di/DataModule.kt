package com.github.aptemkov.onlinestore.app.di

import com.github.aptemkov.onlinestore.data.repository.AuthorizationRepositoryImpl
import com.github.aptemkov.onlinestore.data.api.StoreApiService
import com.github.aptemkov.onlinestore.data.repository.DataRepositoryImpl
import com.github.aptemkov.onlinestore.domain.repository.AuthorizationRepository
import com.github.aptemkov.onlinestore.domain.repository.DataRepository
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://run.mocky.io/v3/"


@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideAuthRepositoryImpl(): AuthorizationRepository {
        return AuthorizationRepositoryImpl(Firebase.auth)
    }

    @Provides
    @Singleton
    fun provideApiService():StoreApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StoreApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideDataRepository(apiService: StoreApiService):DataRepository {
        return DataRepositoryImpl(apiService)
    }


}