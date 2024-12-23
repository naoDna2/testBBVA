package com.naomi.pruebabbva.infrastructure.di

import com.naomi.pruebabbva.domain.repositories.AuthRepository
import com.naomi.pruebabbva.infrastructure.data.local.spreferences.PreferencesManager
import com.naomi.pruebabbva.infrastructure.data.remote.apis.BbvaApi
import com.naomi.pruebabbva.infrastructure.data.remote.apis.BbvaImagesApi
import com.naomi.pruebabbva.infrastructure.repositories.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RepositoriesModule {

    @Provides
    @Singleton
    fun provideAuthRepository(bbvaApi: BbvaApi, bbvaImagesApi: BbvaImagesApi, preferencesManager: PreferencesManager): AuthRepository {
        return AuthRepositoryImpl(bbvaApi, bbvaImagesApi, preferencesManager)
    }
}