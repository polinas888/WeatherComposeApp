package com.example.weathercomposeapp.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.weathercomposeapp.navigation.WeatherScreens

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchField(
    hint: String,
    modifier: Modifier,
    navController: NavController
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    var cityName by remember { mutableStateOf("") }

    Box(
        modifier.fillMaxWidth().padding(14.dp)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = cityName,
            onValueChange = { value -> cityName = value },
            shape = RoundedCornerShape(16.dp),
            placeholder = {
                Text(text = hint)
            },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Blue,
                unfocusedIndicatorColor = Color.Gray,
                backgroundColor = Color.Transparent,
                cursorColor = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
                textColor = Color.Blue
            ),
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = {
                keyboardController?.hide()
                navController.navigate(route = WeatherScreens.MainScreen.name + "/$cityName")
            }),
        )
    }
}
