package com.cascer.thegameapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShortScreenshot(
    val id: Int,
    val image: String
) : Parcelable