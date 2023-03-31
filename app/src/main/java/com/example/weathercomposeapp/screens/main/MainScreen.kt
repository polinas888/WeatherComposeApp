package com.example.weathercomposeapp.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.weathercomposeapp.R
import com.example.weathercomposeapp.components.TopAppBar
import com.example.weathercomposeapp.model.DayWeather
import com.example.weathercomposeapp.model.FavoriteLocation
import com.example.weathercomposeapp.model.Weather
import com.example.weathercomposeapp.navigation.WeatherScreens
import com.example.weathercomposeapp.repository.DataResult
import com.example.weathercomposeapp.utils.createDateString
import com.example.weathercomposeapp.utils.createTimeString
import com.example.weathercomposeapp.utils.getWeatherImageUrl
import kotlin.math.roundToInt

@Composable
fun MainScreen(
    navController: NavController,
    city: String,
    mainViewModel: MainViewModel = hiltViewModel()
) {
    var dataResult by remember {
        mutableStateOf(DataResult<Weather, Boolean, Exception>(loading = true))
    }

    LaunchedEffect(Unit) {
        dataResult = mainViewModel.getWeather(city)
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        if (dataResult.data != null) {
            val todayWeather = dataResult.data!!.list[0]
            Scaffold(
                topBar = {
                    TopAppBar(
                        text = "${city}, ${dataResult.data!!.city.country}",
                        elevation = 16.dp,
                        isMainScreen = true,
                        navController = navController,
                        onSearchClicked = { navController.navigate(WeatherScreens.SearchScreen.name) },
                        onFavoriteClicked = {
                            val favoriteLocation = FavoriteLocation(city, dataResult.data!!.city.country)
                            mainViewModel.saveFavoriteLocation(favoriteLocation)
                        })
                }) { innerPadding ->
                //innerPadding will take into account the height of the top app bar
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = createDateString(todayWeather.dt),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(10.dp)
                    )
                    CirclePictureWithData(
                        getWeatherImageUrl(todayWeather.weather[0].icon),
                        todayWeather.temp.day.roundToInt().toString(),
                        todayWeather.weather[0].main
                    )
                    WeatherConditions(todayWeather)
                    Divider()
                    SunsetSunriseInfo(todayWeather)
                    Text(
                        text = stringResource(R.string.this_week_text),
                        style = MaterialTheme.typography.h6
                    )
                    WeekWeatherList(dataResult.data!!.list)
                }
            }
        } else if (dataResult.loading == true) {
            CircularProgressIndicator()
        } else {
            Text(text = stringResource(R.string.no_weather_text))
        }
    }
}

@Composable
fun CirclePictureWithData(imageUrl: String, temp: String, precipitation: String) {
    Box(
        modifier = Modifier
            .size(160.dp)
            .clip(CircleShape)
            .background(Color(214, 195, 26, 255)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = "sun and cloud picture",
                modifier = Modifier.size(60.dp)
            )
            Text(
                text = "$temp°",
                style = MaterialTheme.typography.h4,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = precipitation,
                style = MaterialTheme.typography.caption,
                fontSize = 16.sp,
                color = Color.Black
            )
        }
    }
}

@Composable
fun SunsetSunriseInfo(todayWeather: DayWeather) {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        SunriseInfo(todayWeather.sunrise)
        SunsetInfo(todayWeather.sunset)
    }
}

@Composable
fun SunriseInfo(sunriseTime: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.sunrise),
            contentDescription = "sunrise picture",
            modifier = Modifier.size(22.dp)
        )
        Text(text = createTimeString(sunriseTime), modifier = Modifier.padding(4.dp))
    }
}

@Composable
fun SunsetInfo(sunsetTime: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = createTimeString(sunsetTime), modifier = Modifier.padding(4.dp))
        Image(
            painter = painterResource(id = R.drawable.sunset),
            contentDescription = "sunset picture",
            modifier = Modifier.size(22.dp)
        )
    }
}


@Composable
fun WeatherConditions(todayWeather: DayWeather) {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        WeatherConditionItem(
            image = R.drawable.humidity,
            description = "humidity picture",
            conditionValue = todayWeather.humidity
        )
        WeatherConditionItem(
            image = R.drawable.pressure,
            description = "pressure picture",
            conditionValue = todayWeather.pressure
        )
        WeatherConditionItem(
            image = R.drawable.wind,
            description = "wind picture",
            conditionValue = todayWeather.speed.toInt()
        )
    }
}

@Composable
fun WeatherConditionItem(image: Int, description: String, conditionValue: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = description,
            modifier = Modifier.size(22.dp)
        )
        fun getConditionString() =
            when (image) {
                R.drawable.humidity -> "$conditionValue%"
                R.drawable.pressure -> "$conditionValue psi"
                R.drawable.wind -> "$conditionValue m/sec"
                else -> " "
            }
        Text(text = getConditionString(), modifier = Modifier.padding(4.dp))
    }
}