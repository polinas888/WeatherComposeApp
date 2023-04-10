package com.example.weathercomposeapp.data.settings

import com.example.weathercomposeapp.model.MetricSystem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SettingsDataSource @Inject constructor(settingsDao: SettingsDao) :
    SettingsDao {
    private val settingsDao by lazy {
        settingsDao
    }

    override suspend fun insertMetricSystem(metricSystem: MetricSystem) {
        settingsDao.insertMetricSystem(metricSystem)
    }

    override fun getMetricSystems(): Flow<List<MetricSystem>> {
        return settingsDao.getMetricSystems()
    }

    override suspend fun deleteAllMetricSystems() {
        settingsDao.deleteAllMetricSystems()
    }
}