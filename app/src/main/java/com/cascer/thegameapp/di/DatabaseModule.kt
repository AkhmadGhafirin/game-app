package com.cascer.thegameapp.di

import android.content.Context
import com.cascer.thegameapp.data.local.room.GameDao
import com.cascer.thegameapp.data.local.room.GameDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideGameDatabase(@ApplicationContext context: Context): GameDatabase {
        return GameDatabase.getDatabase(context)
    }

    @Provides
    fun provideGameDao(database: GameDatabase): GameDao {
        return database.dao()
    }
}