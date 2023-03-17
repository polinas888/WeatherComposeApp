package com.example.weathercomposeapp.screens.main

import androidx.lifecycle.ViewModel
import com.example.weathercomposeapp.model.Weather
import com.example.weathercomposeapp.repository.DataResult
import com.example.weathercomposeapp.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val weatherRepository: WeatherRepository) :
    ViewModel() {

    suspend fun getWeather(city: String): DataResult<Weather, Boolean, Exception> {
        return weatherRepository.getWeather(city)
    }
}
