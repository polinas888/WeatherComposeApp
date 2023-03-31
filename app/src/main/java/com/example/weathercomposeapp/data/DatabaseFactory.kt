package com.example.weathercomposeapp.data

import android.content.Context
import androidx.room.Room
import com.example.weathercomposeapp.utils.Constants.DATABASE_NAME

class DatabaseFactory private constructor(context: Context) {

    val database: ForecastDatabase = Room.databaseBuilder(
        context.applicationContext,
        ForecastDatabase::class.java,
        DATABASE_NAME
    ).build()

    companion object {
        private var INSTANCE: DatabaseFactory? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = DatabaseFactory(context)
            }
        }

        fun get(): DatabaseFactory {
            return INSTANCE
                ?: throw IllegalStateException("WeatherLocalRepository must be initialized")
        }
    }
}