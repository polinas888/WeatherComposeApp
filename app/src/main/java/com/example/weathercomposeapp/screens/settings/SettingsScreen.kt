package com.example.weathercomposeapp.screens.settings

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.weathercomposeapp.R
import com.example.weathercomposeapp.components.TopAppBar
import com.example.weathercomposeapp.model.MetricSystem

@Composable
fun SettingScreen(navController: NavController, settingsViewModel: SettingsViewModel = hiltViewModel()
) {
    val sharedPreferences = LocalContext.current.getSharedPreferences("toggle_prefs", Context.MODE_PRIVATE)

    var toggleBtnChecked by rememberSaveable {
        mutableStateOf(sharedPreferences.getBoolean("toggleBtnChecked", false))
    }

    var metricSystem by rememberSaveable {
        mutableStateOf("metric")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                text = stringResource(id = R.string.settings),
                elevation = 16.dp,
                navController = navController,
                navigationIcon = Icons.Filled.ArrowBack,
                onNavigationIconClicked = { navController.navigateUp() })
        }) { innerPadding -> //innerPadding will take into account the height of the top app bar
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
        ) {
            Text(text = stringResource(id = R.string.change_measurement), style = MaterialTheme.typography.h6)
            IconToggleButton(checked = toggleBtnChecked, onCheckedChange = {
                toggleBtnChecked = ! toggleBtnChecked
                sharedPreferences.edit().putBoolean("toggleBtnChecked", toggleBtnChecked).apply()
                metricSystem = if(toggleBtnChecked) "imperial" else "metric"
            }, modifier = Modifier
                .padding(top = 24.dp, bottom = 24.dp)
                .fillMaxWidth(0.5f)
                .background(Color.Magenta)) {
                Text(text = if (toggleBtnChecked) stringResource(id = R.string.fahrenheit) else stringResource(id = R.string.celsius), style = MaterialTheme.typography.h6, color = Color.White)
            }
            Button(onClick = {
                       settingsViewModel.deleteAllMetricSystems()
                       settingsViewModel.insertMetricSystem(MetricSystem(metricSystem))
            }, shape = RoundedCornerShape(50), colors = ButtonDefaults.buttonColors(backgroundColor = Color(214, 195, 26, 255))) {
                Text(text = "Save", style = MaterialTheme.typography.h6)
            }
        }
    }
}