package com.codinfinity.splity.di

import com.codinfinity.splity.data.repository.AuthRepositoryImpl
import com.codinfinity.splity.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun providesRepository(
        impl: AuthRepositoryImpl
    ): AuthRepository = impl

}