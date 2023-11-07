package com.cascer.thegameapp.domain.usecase

import com.cascer.thegameapp.data.Resource
import com.cascer.thegameapp.domain.model.Game
import com.cascer.thegameapp.domain.repository.GameRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GameUseCaseImpl @Inject constructor(
    private val gameRepository: GameRepository
) : GameUseCase {

    override fun getAllGame(): Flow<Resource<List<Game>>> = gameRepository.getAllGame()

    override fun getFavoriteGames(): Flow<List<Game>> = gameRepository.getFavoriteGames()

    override fun setFavoriteGame(game: Game, newState: Boolean) =
        gameRepository.setFavoriteGame(game, newState)
}