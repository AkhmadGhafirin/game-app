package com.cascer.thegameapp.data.local

import com.cascer.thegameapp.data.local.entity.GameEntity
import com.cascer.thegameapp.data.local.room.GameDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val gameDao: GameDao) {

    fun getAllGame(): Flow<List<GameEntity>> = gameDao.getAllGame()

    fun insertGames(data: List<GameEntity>) = gameDao.insertGames(data)

    fun getFavoriteGames(): Flow<List<GameEntity>> = gameDao.getFavoriteGames()

    fun setFavoriteGame(game: GameEntity, newState: Boolean) {
        game.isFavorite = newState
        gameDao.updateFavoriteGame(game)
    }
}