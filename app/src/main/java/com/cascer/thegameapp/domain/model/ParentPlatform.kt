package com.cascer.thegameapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ParentPlatform(
    val platform: Platform
) : Parcelable