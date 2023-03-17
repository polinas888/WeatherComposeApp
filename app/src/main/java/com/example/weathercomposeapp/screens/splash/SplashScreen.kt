package com.example.weathercomposeapp.screens.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.weathercomposeapp.navigation.WeatherScreens
import com.example.weathercomposeapp.utils.Constants.defaultCity
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController) {
    //scale(size) of image(make splash effect)
    val scale = remember {
        Animatable(0f)
    }

    //make image disappear before navigate to other screen(either way we have effect that image appear
    // in left top conner before loader appears
    val alpha = remember {
        Animatable(1f)
    }

    //key1 - true- run just ones when compose, false - rerun if recomposed
    //animationSpec - tween, spring, repeatable, keyframes, snap, decay
    //OvershootInterpolator - show interpolator(выброс) compose increase and after that decrease,
    // easing - speed
    LaunchedEffect(key1 = true, block = {
        scale.animateTo(
            targetValue = 1f, tween(durationMillis = 1000, easing = {
                OvershootInterpolator(2f).getInterpolation(it)
            })
        )
        delay(2000)
        alpha.animateTo(
            targetValue = 0f,
            animationSpec = tween(durationMillis = 500)
        )
        navController.navigate(WeatherScreens.MainScreen.name + "/$defaultCity")
    })

    Surface(
        modifier = Modifier
            .size(330.dp)
            .padding(16.dp)
            .scale(scale.value)
            .alpha(alpha.value),
             shape = CircleShape, border = BorderStroke(3.dp, Color.LightGray)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = com.example.weathercomposeapp.R.drawable.sun),
                contentDescription = "sun and cloud picture",
                modifier = Modifier.size(95.dp)
            )
            Text(text = "Find the sun?", style = MaterialTheme.typography.h6, color = Color.Gray)
        }
    }
}