package com.cascer.thegameapp.data

import com.cascer.thegameapp.data.local.LocalDataSource
import com.cascer.thegameapp.data.remote.RemoteDataSource
import com.cascer.thegameapp.data.remote.network.ApiResponse
import com.cascer.thegameapp.data.remote.response.GameResponse
import com.cascer.thegameapp.domain.model.Game
import com.cascer.thegameapp.domain.repository.GameRepository
import com.cascer.thegameapp.utils.AppExecutors
import com.cascer.thegameapp.utils.DataMapper.toDomain
import com.cascer.thegameapp.utils.DataMapper.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : GameRepository {
    override fun getAllGame(): Flow<Resource<List<Game>>> =
        object : NetworkBoundResource<List<Game>, List<GameResponse>>() {
            override fun loadFromDB(): Flow<List<Game>> {
                return localDataSource.getAllGame().map { list -> list.map { it.toDomain() } }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<GameResponse>>> =
                remoteDataSource.getAllMovie()

            override suspend fun saveCallResult(data: List<GameResponse>) {
                val games = data.map { it.toEntity() }
                localDataSource.insertGames(games)
            }

//            override fun shouldFetch(data: List<Game>?): Boolean = data.isNullOrEmpty()
            override fun shouldFetch(data: List<Game>?): Boolean = true

        }.asFlow()
}