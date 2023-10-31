package com.cascer.thegameapp.domain.model

data class Store(
    val domain: String,
    val gamesCount: Int,
    val id: Int,
    val imageBackground: String,
    val name: String,
    val slug: String
)