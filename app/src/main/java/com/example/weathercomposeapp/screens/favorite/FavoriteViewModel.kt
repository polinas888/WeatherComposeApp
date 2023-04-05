package com.example.weathercomposeapp.screens.favorite

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathercomposeapp.model.FavoriteLocation
import com.example.weathercomposeapp.repository.DataResult
import com.example.weathercomposeapp.repository.FavoriteLocationsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val favoriteLocationsRepository: FavoriteLocationsRepository): ViewModel() {
    private val _favoriteLocations = mutableStateOf(DataResult<List<FavoriteLocation>, Boolean, Exception>(loading = true))
    val favoriteLocations: State<DataResult<List<FavoriteLocation>, Boolean, Exception>> = _favoriteLocations

    init {
        getFavoriteLocations()
    }

    fun deleteFavoriteLocation(favoriteLocation: FavoriteLocation) {
        viewModelScope.launch {
            try {
                favoriteLocationsRepository.deleteFavoriteLocation(favoriteLocation)
            } catch (e: Exception) {
                Log.i("Database", "Couldn't delete favorite location")
            }
        }
    }

    private fun getFavoriteLocations() {
        viewModelScope.launch {
            try {
                _favoriteLocations.value = DataResult(loading = true)
                favoriteLocationsRepository.getFavoriteLocations().distinctUntilChanged().collect {locations ->
                    _favoriteLocations.value = DataResult(data = locations, loading = false)
                }
            } catch (e: Exception) {
                _favoriteLocations.value = DataResult(error = e, loading = false)
            }
        }
    }
}