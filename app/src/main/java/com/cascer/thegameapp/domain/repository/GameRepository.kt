package com.cascer.thegameapp.domain.repository

import com.cascer.thegameapp.data.Resource
import com.cascer.thegameapp.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface GameRepository {
    fun getAllGame(): Flow<Resource<List<Game>>>
}