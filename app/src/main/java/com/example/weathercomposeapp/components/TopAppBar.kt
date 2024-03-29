package com.example.weathercomposeapp.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.weathercomposeapp.navigation.WeatherScreens
import com.example.weathercomposeapp.screens.favorite.FavoriteViewModel

@Composable
fun TopAppBar(
    navController: NavController,
    favoriteViewModel: FavoriteViewModel = hiltViewModel(),
    text: String,
    modifier: Modifier = Modifier,
    navigationIcon: ImageVector? = null,
    backgroundColor: Color = Color.White,
    elevation: Dp = 16.dp,
    isMainScreen: Boolean = false,
    onSearchClicked: (() -> Unit)? = null,
    onNavigationIconClicked: (() -> Unit)? = null,
    onFavoriteClicked: (() -> Unit)? = null
) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text, textAlign = TextAlign.Center, modifier = Modifier
                        .weight(1f)
                )
                if (isMainScreen) {
                    Row(horizontalArrangement = Arrangement.End) {
                        onSearchClicked.let {
                            IconButton(onClick = onSearchClicked!!) {
                                Icon(
                                    Icons.Default.Search,
                                    "search icon"
                                )
                            }
                        }
                        DropdownMenu(navController)
                    }
                }
            }
        },
        navigationIcon = {
            if (isMainScreen) {
                FavoriteItem(favoriteViewModel, text, onFavoriteClicked)
            } else {
                NavigationItem(onNavigationIconClicked, navigationIcon)
            }
        },
        backgroundColor = backgroundColor,
        elevation = elevation,
        modifier = modifier.padding(6.dp)
    )
}

@Composable
fun FavoriteItem(favoriteViewModel: FavoriteViewModel, text: String, onFavoriteClicked: (() -> Unit)?) {
    val isAlreadyFavorite =
        favoriteViewModel.favoriteLocations.value.data?.filter { location ->
            location.city == text.split(",")[0]
        }

        if (isAlreadyFavorite.isNullOrEmpty()) {
            onFavoriteClicked.let {
                if (onFavoriteClicked != null) {
                    IconButton(onClick = onFavoriteClicked) {
                        Icon(
                            Icons.Default.Favorite,
                            contentDescription = "favorite icon",
                            tint = Color.Red
                        )
                    }
                }
            }
        } else {
            Box {}
        }
    }

@Composable
fun NavigationItem(onNavigationIconClicked: (() -> Unit)?, navigationIcon: ImageVector?) {
    if (onNavigationIconClicked != null) {
        IconButton(onClick = onNavigationIconClicked) {
            if (navigationIcon != null) {
                Icon(navigationIcon, "back")
            }
        }
    }
}

@Composable
fun DropdownMenu(navController: NavController) {
    var expanded by remember { mutableStateOf(false) }
    val menuItems = listOf(
        MenuItem(Icons.Default.Info, MenuItemLabel.ABOUT),
        MenuItem(Icons.Default.Favorite, MenuItemLabel.FAVORITE),
        MenuItem(Icons.Default.Settings, MenuItemLabel.SETTINGS)
    )
    IconButton(onClick = { expanded = true }) {
        Icon(
            Icons.Default.MoreVert,
            "menu icon",
            modifier = Modifier.padding(end = 16.dp)
        )
    }
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false },
        modifier = Modifier.width(IntrinsicSize.Min)
    ) {
        menuItems.forEach { item ->
            DropdownMenuItem(onClick = {
                when (item.label) {
                    MenuItemLabel.ABOUT -> navController.navigate(WeatherScreens.AboutScreen.name)
                    MenuItemLabel.FAVORITE -> navController.navigate(WeatherScreens.FavoriteScreen.name)
                    MenuItemLabel.SETTINGS -> navController.navigate(WeatherScreens.SettingScreen.name)
                }
                expanded = false
            }) {
                MenuItemContent(icon = item.icon, label = item.label)
            }
        }
    }
}

@Composable
fun MenuItemContent(icon: ImageVector, label: MenuItemLabel) {
    Row {
        Icon(
            icon,
            contentDescription = label.toString(),
            modifier = Modifier.padding(end = 6.dp),
            tint = Color.Gray
        )
        Text(label.toString(), color = Color.Gray)
    }
}

data class MenuItem(val icon: ImageVector, val label: MenuItemLabel)

enum class MenuItemLabel {
    ABOUT,
    FAVORITE,
    SETTINGS
}