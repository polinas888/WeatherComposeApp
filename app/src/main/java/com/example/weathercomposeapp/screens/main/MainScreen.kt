package com.example.weathercomposeapp.screens.main

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.weathercomposeapp.repository.DataResult
import com.example.weathercomposeapp.screens.main.MainViewModel

@Composable
fun MainScreen(navController: NavController, mainViewModel: MainViewModel = hiltViewModel()) {
    val weatherStateResult = mainViewModel.weatherStateResult.value as DataResult.Ok
    Text(text = "${weatherStateResult.response?.city?.name}")
}