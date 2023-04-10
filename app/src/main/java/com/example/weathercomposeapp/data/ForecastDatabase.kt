package com.example.weathercomposeapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.weathercomposeapp.data.favorites.FavoriteLocationDao
import com.example.weathercomposeapp.data.settings.SettingsDao
import com.example.weathercomposeapp.model.FavoriteLocation
import com.example.weathercomposeapp.model.MetricSystem

@Database(entities = [FavoriteLocation::class, MetricSystem::class], version = 1, exportSchema = false)
abstract class ForecastDatabase : RoomDatabase() {
    abstract fun favoriteLocationsDao(): FavoriteLocationDao
    abstract fun settingsDao(): SettingsDao
}