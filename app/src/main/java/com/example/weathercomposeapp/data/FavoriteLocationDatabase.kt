package com.example.weathercomposeapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.weathercomposeapp.model.FavoriteLocation

@Database(entities = [FavoriteLocation::class], version = 1, exportSchema = false)
abstract class FavoriteLocationDatabase : RoomDatabase() {
    abstract fun favoriteLocationsDao(): FavoriteLocationDao
}