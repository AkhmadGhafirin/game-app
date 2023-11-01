package com.cascer.thegameapp.utils

import com.cascer.thegameapp.data.local.entity.GameEntity
import com.cascer.thegameapp.data.local.entity.ParentPlatformEntity
import com.cascer.thegameapp.data.local.entity.PlatformEntity
import com.cascer.thegameapp.data.remote.response.GameResponse
import com.cascer.thegameapp.data.remote.response.ParentPlatformResponse
import com.cascer.thegameapp.domain.model.AddedByStatus
import com.cascer.thegameapp.domain.model.EsrbRating
import com.cascer.thegameapp.domain.model.Game
import com.cascer.thegameapp.domain.model.ParentPlatform
import com.cascer.thegameapp.domain.model.Platform

object DataMapper {
    fun GameResponse.toEntity() = GameEntity(
        added = added ?: 0,
        backgroundImage = backgroundImage.orEmpty(),
        dominantColor = dominantColor.orEmpty(),
        id = id ?: 0,
        metacritic = metacritic ?: 0,
        name = name.orEmpty(),
        parentPlatforms = parentPlatforms?.map { it.toEntity() } ?: listOf(),
        playtime = playtime ?: 0,
        rating = rating ?: 0.0,
        ratingTop = ratingTop ?: 0,
        ratingsCount = ratingsCount ?: 0,
        released = released.orEmpty(),
        reviewsCount = reviewsCount ?: 0,
        reviewsTextCount = reviewsTextCount ?: 0,
        saturatedColor = saturatedColor.orEmpty(),
        slug = slug.orEmpty(),
        suggestionsCount = suggestionsCount ?: 0,
        tba = tba ?: false,
        updated = updated.orEmpty()
    )

    private fun ParentPlatformResponse.toEntity() = ParentPlatformEntity(
        platform = PlatformEntity(
            gamesCount = platform?.gamesCount ?: 0,
            id = platform?.id ?: 0,
            image = platform?.image.orEmpty(),
            imageBackground = platform?.imageBackground.orEmpty(),
            name = platform?.name.orEmpty(),
            slug = platform?.slug.orEmpty(),
            yearEnd = platform?.yearEnd ?: 0,
            yearStart = platform?.yearStart ?: 0
        )
    )

    fun GameEntity.toDomain() = Game(
        added = added,
        addedByStatus = AddedByStatus(0, 0, 0, 0, 0, 0),
        backgroundImage = backgroundImage,
        dominantColor = dominantColor,
        esrbRating = EsrbRating(0, "", ""),
        genres = listOf(),
        id = id,
        metacritic = metacritic,
        name = name,
        parentPlatforms = parentPlatforms.map { it.toDomain() },
        platforms = listOf(),
        playtime = playtime,
        rating = rating,
        ratingTop = ratingTop,
        ratings = listOf(),
        ratingsCount = ratingsCount,
        released = released,
        reviewsCount = reviewsCount,
        reviewsTextCount = reviewsTextCount,
        saturatedColor = saturatedColor,
        shortScreenshots = listOf(),
        slug = slug,
        stores = listOf(),
        suggestionsCount = suggestionsCount,
        tags = listOf(),
        tba = tba,
        updated = updated
    )

    private fun ParentPlatformEntity.toDomain() = ParentPlatform(
        platform = Platform(
            gamesCount = platform.gamesCount,
            id = platform.id,
            image = platform.image,
            imageBackground = platform.imageBackground,
            name = platform.name,
            slug = platform.slug,
            yearEnd = platform.yearEnd,
            yearStart = platform.yearStart
        )
    )

    fun Game.toEntity() = GameEntity(
        added = added,
        backgroundImage = backgroundImage,
        dominantColor = dominantColor,
        id = id,
        metacritic = metacritic,
        name = name,
        parentPlatforms = parentPlatforms.map { it.toEntity() },
        playtime = playtime,
        rating = rating,
        ratingTop = ratingTop,
        ratingsCount = ratingsCount,
        released = released,
        reviewsCount = reviewsCount,
        reviewsTextCount = reviewsTextCount,
        saturatedColor = saturatedColor,
        slug = slug,
        suggestionsCount = suggestionsCount,
        tba = tba,
        updated = updated
    )

    private fun ParentPlatform.toEntity() = ParentPlatformEntity(
        platform = PlatformEntity(
            gamesCount = platform.gamesCount,
            id = platform.id,
            image = platform.image,
            imageBackground = platform.imageBackground,
            name = platform.name,
            slug = platform.slug,
            yearEnd = platform.yearEnd,
            yearStart = platform.yearStart
        )
    )
}