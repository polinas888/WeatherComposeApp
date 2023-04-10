package com.example.weathercomposeapp.repository.favorites

import com.example.weathercomposeapp.model.FavoriteLocation
import kotlinx.coroutines.flow.Flow

interface FavoriteLocationsRepository {
    suspend fun insertFavoriteLocation(favoriteLocation: FavoriteLocation)
    fun getFavoriteLocations(): Flow<List<FavoriteLocation>>
    suspend fun deleteFavoriteLocation(favoriteLocation: FavoriteLocation)
}