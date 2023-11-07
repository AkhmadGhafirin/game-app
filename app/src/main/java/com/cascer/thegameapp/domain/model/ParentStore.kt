package com.cascer.thegameapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ParentStore(
    val id: Int,
    val store: Store
) : Parcelable