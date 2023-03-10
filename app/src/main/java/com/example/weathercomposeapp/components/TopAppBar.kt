package com.example.weathercomposeapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun TopAppBar(
    text:String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.White,
    elevation: Dp,
    isMainScreen:Boolean = false
) {
    androidx.compose.material.TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text, textAlign = TextAlign.Center, modifier = Modifier
                        .weight(1f)
                )
                if (isMainScreen) {
                    Row(horizontalArrangement = Arrangement.End) {
                        Icon(
                            Icons.Default.Search,
                            "search icon",
                            modifier = Modifier.padding(end = 16.dp)
                        )
                        Icon(Icons.Default.MoreVert, "menu icon")
                    }
                }
            }
        },
        backgroundColor = backgroundColor,
        elevation = elevation,
        modifier = modifier.padding(6.dp)
    )
}