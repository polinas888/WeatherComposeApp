package com.example.weathercomposeapp.data.favorites

import com.example.weathercomposeapp.model.FavoriteLocation
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoriteLocationDataSource @Inject constructor(favoriteLocationDao: FavoriteLocationDao) :
    FavoriteLocationDao {
        private val favoriteLocationService: FavoriteLocationDao by lazy {
            favoriteLocationDao
        }

    override suspend fun insertFavoriteLocation(favoriteLocation: FavoriteLocation) {
        favoriteLocationService.insertFavoriteLocation(favoriteLocation)
    }

    override fun getFavoriteLocations(): Flow<List<FavoriteLocation>> {
        return favoriteLocationService.getFavoriteLocations()
    }

    override suspend fun deleteFavoriteLocation(favoriteLocation: FavoriteLocation) {
        favoriteLocationService.deleteFavoriteLocation(favoriteLocation)
    }

}