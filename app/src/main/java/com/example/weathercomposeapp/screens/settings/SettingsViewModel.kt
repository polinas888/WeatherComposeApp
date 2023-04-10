package com.example.weathercomposeapp.screens.settings

import androidx.lifecycle.ViewModel
import com.example.weathercomposeapp.repository.settings.SettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(private val settingsRepository: SettingsRepository): ViewModel() {
}