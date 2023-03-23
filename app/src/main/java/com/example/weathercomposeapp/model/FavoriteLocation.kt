package com.example.weathercomposeapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.weathercomposeapp.utils.Constants.DATABASE_NAME

@Entity(tableName = DATABASE_NAME)
data class FavoriteLocation(
    @PrimaryKey
    val city: String,
    val country: String
)
