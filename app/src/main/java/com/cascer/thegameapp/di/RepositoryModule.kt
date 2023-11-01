package com.cascer.thegameapp.di

import com.cascer.thegameapp.data.GameRepositoryImpl
import com.cascer.thegameapp.domain.repository.GameRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [DatabaseModule::class, NetworkModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideGameRepository(gameRepository: GameRepositoryImpl): GameRepository
}