package com.cascer.thegameapp.di

import com.cascer.thegameapp.domain.usecase.GameUseCase
import com.cascer.thegameapp.domain.usecase.GameUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideGameUseCase(gameUseCase: GameUseCaseImpl): GameUseCase
}