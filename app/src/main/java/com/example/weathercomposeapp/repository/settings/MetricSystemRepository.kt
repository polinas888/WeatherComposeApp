package com.example.weathercomposeapp.repository.settings

import com.example.weathercomposeapp.model.MetricSystem
import kotlinx.coroutines.flow.Flow

interface MetricSystemRepository {
    suspend fun insertMetricSystem(metricSystem: MetricSystem)
    fun getMetricSystems(): Flow<List<MetricSystem>>
    suspend fun deleteAllMetricSystems()
}