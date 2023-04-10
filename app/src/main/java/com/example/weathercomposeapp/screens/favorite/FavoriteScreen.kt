package com.example.weathercomposeapp.screens.favorite

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.weathercomposeapp.R
import com.example.weathercomposeapp.components.TopAppBar

@Composable
fun FavoriteScreen(
    navController: NavController,
    favoritesViewModel: FavoriteViewModel = hiltViewModel()
) {
    val favoriteLocations = favoritesViewModel.favoriteLocations.value

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        if (!favoriteLocations.data.isNullOrEmpty()) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        text = stringResource(id = R.string.favorite_cities_title),
                        elevation = 16.dp,
                        navController = navController,
                        navigationIcon = Icons.Filled.ArrowBack,
                        onNavigationIconClicked = { navController.navigateUp() })
                }) { innerPadding -> //innerPadding will take into account the height of the top app bar
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    FavoriteLocationList(
                        navController = navController,
                        listItems = favoriteLocations.data!!,
                        onDeleteClicked = { favoriteLocation ->
                            favoritesViewModel.deleteFavoriteLocation(favoriteLocation)
                        })
                }
            }
        } else if (favoriteLocations.loading == true) {
            CircularProgressIndicator()
        } else {
            Text(text = stringResource(R.string.no_favorites_text))
        }
    }
}
