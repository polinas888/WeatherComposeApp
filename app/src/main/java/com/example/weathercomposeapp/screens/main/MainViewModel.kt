package com.example.weathercomposeapp.screens.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathercomposeapp.model.FavoriteLocation
import com.example.weathercomposeapp.model.MetricSystem
import com.example.weathercomposeapp.model.Weather
import com.example.weathercomposeapp.repository.DataResult
import com.example.weathercomposeapp.repository.favorites.FavoriteLocationsRepository
import com.example.weathercomposeapp.repository.weather.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val weatherRepository: WeatherRepository, private val favoriteLocationsRepository: FavoriteLocationsRepository) :
    ViewModel() {

    suspend fun getWeather(city: String, metricSystem: MetricSystem): DataResult<Weather, Boolean, Exception> {
        return weatherRepository.getWeather(city, metricSystem.metricSystem)
    }

    fun saveFavoriteLocation(favoriteLocation: FavoriteLocation) {
        viewModelScope.launch {
            try {
                favoriteLocationsRepository.insertFavoriteLocation(favoriteLocation)
            } catch (e: Exception) {
                Log.i("Database", "can't save favorite location ro database")
            }
        }
    }
}
