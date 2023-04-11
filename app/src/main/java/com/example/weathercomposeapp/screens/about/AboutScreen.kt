package com.example.weathercomposeapp.screens.about

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.weathercomposeapp.R
import com.example.weathercomposeapp.components.TopAppBar

@Composable
fun AboutScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                text = stringResource(id = R.string.about),
                elevation = 16.dp,
                navController = navController,
                navigationIcon = Icons.Filled.ArrowBack,
                onNavigationIconClicked = { navController.navigateUp() })
        }) { innerPadding -> //innerPadding will take into account the height of the top app bar
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.weather_api),
                style = MaterialTheme.typography.h6
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Weather data from: ",
                    modifier = Modifier.padding(end = 4.dp),
                    fontSize = 16.sp
                )
                val context = LocalContext.current
                val annotatedString = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Blue,
                            textDecoration = TextDecoration.Underline,
                            fontSize = 16.sp
                        )
                    ) {
                        append("https://openweathermap.org")
                    }
                }
                ClickableText(
                    text = annotatedString,
                    onClick = {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://openweathermap.org"))
                        context.startActivity(intent)
                    }
                )
            }
        }
    }
}
