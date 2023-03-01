package com.example.weathercomposeapp.screens.main

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.weathercomposeapp.repository.DataResult

@Composable
fun MainScreen(navController: NavController, mainViewModel: MainViewModel = hiltViewModel()) {
    val weatherStateResult = mainViewModel.weatherStateResult.value as DataResult.Ok
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        if (weatherStateResult.response?.city?.name != null) {
            Text(text = weatherStateResult.response.city.name)
        }
        if (mainViewModel.isLoading.value) {
            CircularProgressIndicator()
        }
    }
}
