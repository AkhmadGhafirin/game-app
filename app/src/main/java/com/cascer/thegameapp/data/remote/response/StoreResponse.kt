package com.cascer.thegameapp.data.remote.response


import com.google.gson.annotations.SerializedName

data class StoreResponse(
    @SerializedName("domain")
    val domain: String?,
    @SerializedName("games_count")
    val gamesCount: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image_background")
    val imageBackground: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("slug")
    val slug: String?
)