package com.cascer.thegameapp.ui.detail

import androidx.lifecycle.ViewModel
import com.cascer.thegameapp.domain.model.Game
import com.cascer.thegameapp.domain.usecase.GameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val gameUseCase: GameUseCase) : ViewModel() {
    fun setFavoriteGame(game: Game, newState: Boolean) {
        gameUseCase.setFavoriteGame(game, newState)
    }
}