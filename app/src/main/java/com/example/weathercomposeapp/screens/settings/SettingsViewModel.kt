package com.example.weathercomposeapp.screens.settings

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathercomposeapp.model.MetricSystem
import com.example.weathercomposeapp.repository.settings.SettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(private val settingsRepository: SettingsRepository): ViewModel() {

    fun deleteAllMetricSystems() {
        viewModelScope.launch {
            try {
                settingsRepository.deleteAllMetricSystems()
            } catch (e: Exception) {
                Log.i("Database", "Couldn't delete metric systems")
            }
        }
    }

    fun insertMetricSystem(metricSystem: MetricSystem) {
        viewModelScope.launch {
            try {
                settingsRepository.insertMetricSystem(metricSystem)
            } catch (e: Exception) {
                Log.i("Database", "Couldn't insert metric system")
            }
        }
    }

    fun getMetricSystems(): Flow<List<MetricSystem>> {
        return settingsRepository.getMetricSystems()
    }
}