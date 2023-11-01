package com.cascer.thegameapp.data.local.entity


import com.google.gson.annotations.SerializedName

data class PlatformEntity(
    val gamesCount: Int,
    val id: Int,
    val image: String,
    val imageBackground: String,
    val name: String,
    val slug: String,
    val yearEnd: Int,
    val yearStart: Int
)