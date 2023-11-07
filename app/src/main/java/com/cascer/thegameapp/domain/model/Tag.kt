package com.cascer.thegameapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Tag(
    val gamesCount: Int,
    val id: Int,
    val imageBackground: String,
    val language: String,
    val name: String,
    val slug: String
) : Parcelable