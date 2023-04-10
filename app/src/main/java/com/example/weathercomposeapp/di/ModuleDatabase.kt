package com.example.weathercomposeapp.di

import com.example.weathercomposeapp.data.DatabaseFactory
import com.example.weathercomposeapp.data.favorites.FavoriteLocationDao
import com.example.weathercomposeapp.data.favorites.FavoriteLocationDataSource
import com.example.weathercomposeapp.data.settings.MetricSystemDao
import com.example.weathercomposeapp.data.settings.MetricSystemDataSource
import com.example.weathercomposeapp.repository.favorites.FavoriteLocationsRepositoryImp
import com.example.weathercomposeapp.repository.settings.MetricSystemRepositoryImp
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
    fun provideMetricSystemDao(): MetricSystemDao {
        return DatabaseFactory.get().database.metricSystemDao()
    }

    @Provides
    fun  provideMetricSystemDataSource(metricSystemDao: MetricSystemDao) : MetricSystemDataSource {
        return MetricSystemDataSource(metricSystemDao)
    }

    @Provides
    fun provideMetricSystemRepositoryImp(metricSystemDataSource: MetricSystemDataSource) : MetricSystemRepositoryImp {
        return MetricSystemRepositoryImp(metricSystemDataSource)
    }
}