package com.example.weathercomposeapp.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weathercomposeapp.model.DayWeather
import com.example.weathercomposeapp.utils.getDayOfWeek
import com.example.weathercomposeapp.utils.getWeatherImageUrl
import kotlin.math.roundToInt

@Composable
fun WeekWeatherList(listItems: List<DayWeather>) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(2.dp))
            .background(Color(243, 243, 243, 255))
    ) {
        LazyColumn {
            items(items = listItems) { dayWeather ->
                DayWeatherItem(
                    dayWeather.dt,
                    getWeatherImageUrl(dayWeather.weather[0].icon),
                    dayWeather.weather[0].main,
                    dayWeather.temp.day.roundToInt().toString(),
                    dayWeather.temp.night.roundToInt().toString()
                )
            }
        }
    }
}

@Composable
fun DayWeatherItem(
    dateMilsec: Int,
    imageUrl: String,
    precipitation: String,
    temDay: String,
    tempNight: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clip(RoundedCornerShape(topStart = 30.dp, bottomStart = 30.dp, bottomEnd = 30.dp))
            .background(Color.White), contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = getDayOfWeek(dateMilsec))
            AsyncImage(
                model = imageUrl,
                contentDescription = "sun and cloud picture",
                modifier = Modifier.size(60.dp)
            )
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(30.dp))
                    .background(Color(214, 195, 26, 255))
            ) {
                Text(text = precipitation, modifier = Modifier.padding(4.dp))
            }
            Text(buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                ) {
                    append("$temDay° ")
                }
                withStyle(style = SpanStyle(Color.Gray, fontSize = 20.sp)) {
                    append("$tempNight°")
                }
            })
        }
    }
}