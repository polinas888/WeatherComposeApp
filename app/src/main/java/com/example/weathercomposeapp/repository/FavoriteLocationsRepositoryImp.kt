package com.example.weathercomposeapp.repository

import com.example.weathercomposeapp.data.FavoriteLocationDataSource
import com.example.weathercomposeapp.model.FavoriteLocation
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoriteLocationsRepositoryImp @Inject constructor(private val favoriteLocationDataSource: FavoriteLocationDataSource): FavoriteLocationsRepository {
    override suspend fun insertFavoriteLocation(favoriteLocation: FavoriteLocation) {
        favoriteLocationDataSource.insertFavoriteLocation(favoriteLocation)
    }

    override fun getFavoriteLocations(): Flow<List<FavoriteLocation>> {
        return favoriteLocationDataSource.getFavoriteLocations()
    }

    override suspend fun deleteFavoriteLocation(favoriteLocation: FavoriteLocation) {
        favoriteLocationDataSource.deleteFavoriteLocation(favoriteLocation)
    }
}