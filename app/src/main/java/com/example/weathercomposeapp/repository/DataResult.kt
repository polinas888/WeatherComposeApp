package com.example.weathercomposeapp.repository

class DataResult<T, Boolean, E: Exception>(
    var data: T? = null,
    var loading: kotlin.Boolean? = null,
    var error: E? = null)