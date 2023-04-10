package com.example.weathercomposeapp.data.settings

import com.example.weathercomposeapp.model.MetricSystem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MetricSystemDataSource @Inject constructor(metricSystemDao: MetricSystemDao) :
    MetricSystemDao {
    private val metricSystemDao by lazy {
        metricSystemDao
    }

    override suspend fun insertMetricSystem(metricSystem: MetricSystem) {
        metricSystemDao.insertMetricSystem(metricSystem)
    }

    override fun getMetricSystems(): Flow<List<MetricSystem>> {
        return metricSystemDao.getMetricSystems()
    }

    override suspend fun deleteAllMetricSystems() {
        metricSystemDao.deleteAllMetricSystems()
    }
}