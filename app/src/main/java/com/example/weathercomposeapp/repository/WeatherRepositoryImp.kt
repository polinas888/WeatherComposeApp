package com.example.weathercomposeapp.repository

import com.example.weathercomposeapp.model.Weather
import com.example.weathercomposeapp.network.WeatherDataSource
import javax.inject.Inject

class WeatherRepositoryImp @Inject constructor(private val weatherDataSource: WeatherDataSource): WeatherRepository {
    override suspend fun getWeather(city: String, metric: String) : DataResult<Weather> {
        return try {
            val weatherData = weatherDataSource.getWeather(city, metric)
            DataResult.Ok(weatherData)
        } catch (e: Exception) {
            DataResult.Error(e.message)
        }
    }
}