package com.example.weathercomposeapp.data.favorites

import androidx.room.*
import com.example.weathercomposeapp.model.FavoriteLocation
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteLocationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteLocation(favoriteLocation: FavoriteLocation)

    @Query("SELECT * FROM favorite_locations")
    fun getFavoriteLocations(): Flow<List<FavoriteLocation>>

    @Delete
    suspend fun deleteFavoriteLocation(favoriteLocation: FavoriteLocation)
}