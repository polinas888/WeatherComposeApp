package com.example.weathercomposeapp.repository

import com.example.weathercomposeapp.model.Weather

interface WeatherRepository {
     suspend fun getWeather(city: String, metric: String = "metric"): DataResult<Weather>
}