package com.cascer.thegameapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Rating(
    val count: Int,
    val id: Int,
    val percent: Double,
    val title: String
) : Parcelable