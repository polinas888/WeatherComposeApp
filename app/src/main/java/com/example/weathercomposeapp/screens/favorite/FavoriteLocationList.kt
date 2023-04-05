package com.example.weathercomposeapp.screens.favorite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.weathercomposeapp.model.FavoriteLocation

@Composable
fun FavoriteLocationList(listItems: List<FavoriteLocation>, onDeleteClicked: (favoriteLocation: FavoriteLocation) -> Unit) {
    Box(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .clip(RoundedCornerShape(2.dp))
        .background(Color(243, 243, 243, 255))
    ) {
        LazyColumn {
            items(items = listItems) { favoriteLocation ->
                FavoriteLocationItem(favoriteLocation, onDeleteClicked)
            }
        }
    }
}

@Composable
fun FavoriteLocationItem(
    favoriteLocation: FavoriteLocation,
    onDeleteClicked: (favoriteLocation: FavoriteLocation) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clip(RoundedCornerShape(topStart = 30.dp, bottomStart = 30.dp, bottomEnd = 30.dp))
            .background(Color(204, 255, 255, 255)), contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = favoriteLocation.city, style = MaterialTheme.typography.h6
            )
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(30.dp))
                    .background(Color.LightGray)
            ) {
                Text(text = favoriteLocation.country, modifier = Modifier.padding(10.dp), fontWeight = FontWeight.Bold)
            }
            IconButton(onClick = {
                onDeleteClicked(favoriteLocation)
            }) {
                Icon(
                    Icons.Default.Delete,
                    "delete icon", tint = Color.Red
                )
            }
        }
    }
}