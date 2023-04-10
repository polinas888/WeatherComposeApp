package com.example.weathercomposeapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.weathercomposeapp.utils.Constants.TABLE_FAVORITE_LOCATIONS

@Entity(tableName = TABLE_FAVORITE_LOCATIONS)
data class FavoriteLocation(
    @PrimaryKey
    val city: String,
    val country: String
)
