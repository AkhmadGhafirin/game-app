package com.cascer.thegameapp.domain.model

data class Platform(
    val gamesCount: Int,
    val id: Int,
    val image: String,
    val imageBackground: String,
    val name: String,
    val slug: String,
    val yearEnd: Int,
    val yearStart: Int
)