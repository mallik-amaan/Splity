package com.codinfinity.splity.di

import com.codinfinity.splity.data.repository.AddFriendRepositoryImpl
import com.codinfinity.splity.data.repository.AuthRepositoryImpl
import com.codinfinity.splity.data.repository.SplitRepositoryImpl
import com.codinfinity.splity.domain.repository.AddFriendRepository
import com.codinfinity.splity.domain.repository.AuthRepository
import com.codinfinity.splity.domain.repository.SplitRepository
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
    fun providesAuthRepository(
        impl: AuthRepositoryImpl
    ): AuthRepository = impl

    @Provides
    @Singleton
    fun providesAddFriendRepository(
        impl: AddFriendRepositoryImpl
    ): AddFriendRepository = impl

    @Provides
    @Singleton
    fun providesSplitRepository(
        impl: SplitRepositoryImpl
    ): SplitRepository = impl


}