package com.example.weathercomposeapp.di

import com.example.weathercomposeapp.data.FavoriteLocationDataSource
import com.example.weathercomposeapp.network.ApiRetrofitFactory
import com.example.weathercomposeapp.network.WeatherApi
import com.example.weathercomposeapp.network.WeatherDataSource
import com.example.weathercomposeapp.repository.FavoriteLocationsRepositoryImp
import com.example.weathercomposeapp.repository.FavoriteLocationsRepository
import com.example.weathercomposeapp.repository.WeatherRepository
import com.example.weathercomposeapp.repository.WeatherRepositoryImp
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
}
