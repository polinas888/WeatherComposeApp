package com.example.weathercomposeapp.di

import com.example.weathercomposeapp.data.DatabaseFactory
import com.example.weathercomposeapp.data.FavoriteLocationDao
import com.example.weathercomposeapp.data.FavoriteLocationDataSource
import com.example.weathercomposeapp.repository.FavoriteLocationsRepositoryImp
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
}