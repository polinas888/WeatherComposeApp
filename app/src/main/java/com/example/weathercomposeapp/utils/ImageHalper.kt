package com.example.weathercomposeapp.utils

fun getWeatherImageUrl(urlCode: String) : String {
    return "https://openweathermap.org/img/wn/${urlCode}.png"
}