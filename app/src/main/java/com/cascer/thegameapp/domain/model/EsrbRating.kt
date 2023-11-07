package com.cascer.thegameapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EsrbRating(
    val id: Int,
    val name: String,
    val slug: String
) : Parcelable