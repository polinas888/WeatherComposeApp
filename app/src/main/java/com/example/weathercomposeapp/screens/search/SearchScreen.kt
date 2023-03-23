package com.example.weathercomposeapp.screens.search

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.weathercomposeapp.components.TopAppBar
import com.example.weathercomposeapp.components.SearchField

@Composable
fun SearchScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                navController = navController,
                text = "Search city",
                navigationIcon = Icons.Filled.ArrowBack,
                onNavigationIconClicked = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        SearchField(hint = "city name", modifier = Modifier.fillMaxSize()
            .padding(innerPadding), navController)
    }
}