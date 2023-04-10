package com.example.weathercomposeapp.di

import com.example.weathercomposeapp.data.DatabaseFactory
import com.example.weathercomposeapp.data.favorites.FavoriteLocationDao
import com.example.weathercomposeapp.data.favorites.FavoriteLocationDataSource
import com.example.weathercomposeapp.data.settings.SettingsDao
import com.example.weathercomposeapp.data.settings.SettingsDataSource
import com.example.weathercomposeapp.repository.favorites.FavoriteLocationsRepositoryImp
import com.example.weathercomposeapp.repository.settings.SettingsRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ModuleDatabase {
    @Provides
    fun provideFavoriteLocationsDao(): FavoriteLocationDao {
        return DatabaseFactory.get().database.favoriteLocationsDao()
    }

    @Provides
    fun  provideFavoriteLocationsDataSource(favoriteLocationDao: FavoriteLocationDao) : FavoriteLocationDataSource {
        return FavoriteLocationDataSource(favoriteLocationDao)
    }

    @Provides
    fun provideFavoriteLocationsRepositoryImp(favoriteLocationDataSource: FavoriteLocationDataSource) : FavoriteLocationsRepositoryImp {
        return FavoriteLocationsRepositoryImp(favoriteLocationDataSource)
    }

    @Provides
    fun provideMetricSystemDao(): SettingsDao {
        return DatabaseFactory.get().database.settingsDao()
    }

    @Provides
    fun  provideMetricSystemDataSource(settingsDao: SettingsDao) : SettingsDataSource {
        return SettingsDataSource(settingsDao)
    }

    @Provides
    fun provideMetricSystemRepositoryImp(settingsDataSource: SettingsDataSource) : SettingsRepositoryImp {
        return SettingsRepositoryImp(settingsDataSource)
    }
}