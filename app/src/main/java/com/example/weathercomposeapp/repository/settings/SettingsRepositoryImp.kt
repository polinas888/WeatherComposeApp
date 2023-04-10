package com.example.weathercomposeapp.repository.settings

import com.example.weathercomposeapp.data.settings.SettingsDataSource
import com.example.weathercomposeapp.model.MetricSystem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SettingsRepositoryImp @Inject constructor(private val settingsDataSource: SettingsDataSource):
    SettingsRepository {
    override suspend fun insertMetricSystem(metricSystem: MetricSystem) {
        settingsDataSource.insertMetricSystem(metricSystem)
    }

    override fun getMetricSystems(): Flow<List<MetricSystem>> {
        return settingsDataSource.getMetricSystems()
    }

    override suspend fun deleteAllMetricSystems() {
        settingsDataSource.deleteAllMetricSystems()
    }
}