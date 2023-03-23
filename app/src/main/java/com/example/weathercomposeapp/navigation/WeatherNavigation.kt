package com.example.weathercomposeapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.weathercomposeapp.screens.search.SearchScreen
import com.example.weathercomposeapp.screens.about.AboutScreen
import com.example.weathercomposeapp.screens.favorite.FavoriteScreen
import com.example.weathercomposeapp.screens.main.MainScreen
import com.example.weathercomposeapp.screens.main.MainViewModel
import com.example.weathercomposeapp.screens.settings.SettingScreen
import com.example.weathercomposeapp.screens.splash.SplashScreen

@Composable
fun WeatherNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = WeatherScreens.SplashScreen.name) {
        composable(WeatherScreens.SplashScreen.name) {
            SplashScreen(navController = navController)
        }
        composable(WeatherScreens.MainScreen.name + "/{city}", arguments = listOf(navArgument(name = "city") {
            type = NavType.StringType
        })) { backStackEntry ->
            backStackEntry.arguments?.getString("city")
                ?.let { city ->
                    val mainViewModel = hiltViewModel<MainViewModel>()
                    MainScreen(navController = navController, city, mainViewModel) }
        }
        composable(WeatherScreens.SearchScreen.name) {
            SearchScreen(navController = navController)
        }
        composable(WeatherScreens.AboutScreen.name) {
            AboutScreen(navController = navController)
        }
        composable(WeatherScreens.FavoriteScreen.name) {
            FavoriteScreen(navController = navController)
        }
        composable(WeatherScreens.SettingScreen.name) {
            SettingScreen(navController = navController)
        }
    }
}