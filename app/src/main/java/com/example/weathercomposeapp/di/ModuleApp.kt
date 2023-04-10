package com.example.weathercomposeapp.di

import com.example.weathercomposeapp.data.favorites.FavoriteLocationDataSource
import com.example.weathercomposeapp.data.settings.SettingsDataSource
import com.example.weathercomposeapp.network.ApiRetrofitFactory
import com.example.weathercomposeapp.network.WeatherApi
import com.example.weathercomposeapp.network.WeatherDataSource
import com.example.weathercomposeapp.repository.favorites.FavoriteLocationsRepositoryImp
import com.example.weathercomposeapp.repository.favorites.FavoriteLocationsRepository
import com.example.weathercomposeapp.repository.settings.SettingsRepository
import com.example.weathercomposeapp.repository.settings.SettingsRepositoryImp
import com.example.weathercomposeapp.repository.weather.WeatherRepository
import com.example.weathercomposeapp.repository.weather.WeatherRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ModuleApp {

    @Provides
    @Singleton
    fun provideWeatherApi(): WeatherApi {
        return ApiRetrofitFactory.weatherApiRetrofit().create(WeatherApi::class.java)
    }

    @Singleton
    @Provides
    fun provideWeatherRepository(weatherDataSource: WeatherDataSource): WeatherRepository {
        return WeatherRepositoryImp(weatherDataSource)
    }

    @Provides
    @Singleton
    fun provideFavoriteLocationsRepository(favoriteLocationDataSource: FavoriteLocationDataSource) : FavoriteLocationsRepository {
        return FavoriteLocationsRepositoryImp(favoriteLocationDataSource)
    }

    @Provides
    @Singleton
    fun provideMetricSystemRepository(settingsDataSource: SettingsDataSource) : SettingsRepository {
        return SettingsRepositoryImp(settingsDataSource)
    }
}
