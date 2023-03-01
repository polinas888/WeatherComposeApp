package com.example.weathercomposeapp.network

import com.example.weathercomposeapp.model.Weather
import javax.inject.Inject

class WeatherDataSource @Inject constructor(private val weatherApi: WeatherApi) : WeatherApi {
    override suspend fun getWeather(city: String, metric: String): Weather {
        return weatherApi.getWeather(city, metric)
    }
}