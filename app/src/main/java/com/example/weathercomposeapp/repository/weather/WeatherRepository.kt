package com.example.weathercomposeapp.repository.weather

import com.example.weathercomposeapp.model.Weather
import com.example.weathercomposeapp.repository.DataResult

interface WeatherRepository {
     suspend fun getWeather(city: String, metric: String = "metric"): DataResult<Weather, Boolean, Exception>
}