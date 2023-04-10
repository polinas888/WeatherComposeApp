package com.example.weathercomposeapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.weathercomposeapp.utils.Constants

@Entity(tableName = Constants.TABLE_METRIC_SYSTEM)
data class MetricSystem(
    @PrimaryKey
    val metricSystem: String
)
