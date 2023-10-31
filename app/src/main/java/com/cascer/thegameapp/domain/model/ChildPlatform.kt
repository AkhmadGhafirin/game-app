package com.cascer.thegameapp.domain.model

data class ChildPlatform(
    val platform: Platform,
    val releasedAt: String,
    val requirementsEn: RequirementsEn,
    val requirementsRu: Any
)