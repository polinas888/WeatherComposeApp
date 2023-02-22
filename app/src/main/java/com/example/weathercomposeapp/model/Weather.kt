package com.example.weathercomposeapp.model

data class Weather(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<DayWeather>,
    val message: Double
)