package com.cascer.thegameapp.data

import com.cascer.thegameapp.data.remote.RemoteDataSource
import com.cascer.thegameapp.domain.model.Game
import com.cascer.thegameapp.domain.repository.GameRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): GameRepository {
    override fun getAllGame(): Flow<Resource<List<Game>>> {
        TODO("Not yet implemented")
    }
}