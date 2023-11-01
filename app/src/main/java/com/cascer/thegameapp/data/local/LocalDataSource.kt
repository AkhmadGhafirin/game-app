package com.cascer.thegameapp.data.local

import com.cascer.thegameapp.data.local.entity.GameEntity
import com.cascer.thegameapp.data.local.room.GameDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val gameDao: GameDao) {

    fun getAllGame(): Flow<List<GameEntity>> = gameDao.getAllGame()

    suspend fun insertGames(data: List<GameEntity>) = gameDao.insertGames(data)
}