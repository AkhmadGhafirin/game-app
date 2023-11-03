package com.cascer.thegameapp.di

import com.cascer.thegameapp.data.GameRepositoryImpl
import com.cascer.thegameapp.data.local.LocalDataSource
import com.cascer.thegameapp.data.local.room.GameDao
import com.cascer.thegameapp.data.remote.RemoteDataSource
import com.cascer.thegameapp.data.remote.network.ApiService
import com.cascer.thegameapp.domain.repository.GameRepository
import com.cascer.thegameapp.utils.AppExecutors
import com.cascer.thegameapp.utils.IoDispatcher
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit

@Module(includes = [DatabaseModule::class, NetworkModule::class])
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @IoDispatcher
    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    fun provideGameRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource,
        appExecutors: AppExecutors,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): GameRepository {
        return GameRepositoryImpl(remoteDataSource, localDataSource, appExecutors, ioDispatcher)
    }

    @Provides
    fun provideRemoteDataSource(
        retrofit: Retrofit
    ): RemoteDataSource {
        return RemoteDataSource(retrofit.create(ApiService::class.java))
    }

    @Provides
    fun provideLocalDataSource(
        gameDao: GameDao
    ): LocalDataSource {
        return LocalDataSource(gameDao)
    }
}