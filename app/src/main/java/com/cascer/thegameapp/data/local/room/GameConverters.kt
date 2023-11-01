package com.cascer.thegameapp.data.local.room

import androidx.room.TypeConverter
import com.cascer.thegameapp.data.local.entity.ParentPlatformEntity
import com.cascer.thegameapp.data.local.entity.PlatformEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GameConverters {
    val gson = Gson()

    @TypeConverter
    fun parentPlatformListToString(data: List<ParentPlatformEntity>): String {
        return gson.toJson(data)
    }

    @TypeConverter
    fun stringToParentPlatformList(data: String): List<ParentPlatformEntity> {
        val objectType = object : TypeToken<List<ParentPlatformEntity>>() {}.type
        return gson.fromJson(data, objectType)
    }

    @TypeConverter
    fun platformToString(data: PlatformEntity): String {
        return gson.toJson(data)
    }

    @TypeConverter
    fun stringToPlatform(data: String): PlatformEntity {
        val objectType = object : TypeToken<PlatformEntity>() {}.type
        return gson.fromJson(data, objectType)
    }
}