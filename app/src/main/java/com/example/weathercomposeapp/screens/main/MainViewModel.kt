package com.example.weathercomposeapp.screens.main

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathercomposeapp.model.Weather
import com.example.weathercomposeapp.repository.DataResult
import com.example.weathercomposeapp.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val weatherRepository: WeatherRepository): ViewModel() {
   val weatherStateResult:MutableState<DataResult<Weather?>> = mutableStateOf(DataResult.Ok(null))

    init {
        getWeather()
    }

    private fun getWeather() {
        viewModelScope.launch {
            try {
                val weatherData = weatherRepository.getWeather("moscow")
                weatherStateResult.value = weatherData
            } catch (e: Exception) {
              Log.e("No weather data", e.message.toString())
            }
        }
    }
}