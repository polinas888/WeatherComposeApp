package com.example.weathercomposeapp.screens.favorite

import androidx.lifecycle.ViewModel
import com.example.weathercomposeapp.repository.FavoriteLocationsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val favoriteLocationsRepository: FavoriteLocationsRepository): ViewModel() {
}