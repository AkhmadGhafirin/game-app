package com.cascer.thegameapp.domain.usecase

import com.cascer.thegameapp.data.Resource
import com.cascer.thegameapp.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface GameUseCase {
    fun getAllGame(): Flow<Resource<List<Game>>>
}