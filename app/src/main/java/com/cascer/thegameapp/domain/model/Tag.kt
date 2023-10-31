package com.cascer.thegameapp.domain.model

data class Tag(
    val gamesCount: Int,
    val id: Int,
    val imageBackground: String,
    val language: String,
    val name: String,
    val slug: String
)