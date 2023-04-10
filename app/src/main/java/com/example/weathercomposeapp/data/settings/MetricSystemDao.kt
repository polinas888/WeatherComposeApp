package com.example.weathercomposeapp.data.settings

import androidx.room.*
import com.example.weathercomposeapp.model.MetricSystem
import kotlinx.coroutines.flow.Flow

@Dao
interface MetricSystemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMetricSystem(metricSystem: MetricSystem)

    @Query("SELECT * FROM metric_system")
    fun getMetricSystems(): Flow<List<MetricSystem>>

    @Query("DELETE FROM metric_system")
    suspend fun deleteAllMetricSystems()
}