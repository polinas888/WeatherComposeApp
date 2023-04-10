package com.example.weathercomposeapp.repository.settings

import com.example.weathercomposeapp.data.settings.MetricSystemDataSource
import com.example.weathercomposeapp.model.MetricSystem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MetricSystemRepositoryImp @Inject constructor(private val metricSystemDataSource: MetricSystemDataSource):
    MetricSystemRepository {
    override suspend fun insertMetricSystem(metricSystem: MetricSystem) {
        metricSystemDataSource.insertMetricSystem(metricSystem)
    }

    override fun getMetricSystems(): Flow<List<MetricSystem>> {
        return metricSystemDataSource.getMetricSystems()
    }

    override suspend fun deleteAllMetricSystems() {
        metricSystemDataSource.deleteAllMetricSystems()
    }
}