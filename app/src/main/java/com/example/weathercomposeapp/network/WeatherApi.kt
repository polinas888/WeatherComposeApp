package com.example.weathercomposeapp.network

import com.example.weathercomposeapp.model.Weather
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface WeatherApi {
    @GET(value = "2.5/forecast/daily")
    suspend fun getWeather(@Query("q") city: String, @Query("units") metric: String) : Weather
}