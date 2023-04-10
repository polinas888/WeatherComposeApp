package com.example.weathercomposeapp.repository.weather

import com.example.weathercomposeapp.model.Weather
import com.example.weathercomposeapp.network.WeatherDataSource
import com.example.weathercomposeapp.repository.DataResult
import javax.inject.Inject

class WeatherRepositoryImp @Inject constructor(private val weatherDataSource: WeatherDataSource):
    WeatherRepository {
    override suspend fun getWeather(city: String, metric: String) : DataResult<Weather, Boolean, Exception> {
        return try {
            val weatherData = weatherDataSource.getWeather(city, metric)
            DataResult(weatherData, false, null)
        } catch (e: Exception) {
            DataResult(null, false, e)
        }
    }
}