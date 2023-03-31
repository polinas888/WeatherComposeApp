package com.example.weathercomposeapp

import android.app.Application
import android.content.Context
import com.example.weathercomposeapp.data.DatabaseFactory
import com.example.weathercomposeapp.di.AppComponent
import com.example.weathercomposeapp.di.DaggerAppComponent
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WeatherApplication: Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(applicationContext)
        DatabaseFactory.initialize(this)
    }
}

val Context.appComponent: AppComponent
    get() = when(this) {
        is WeatherApplication -> appComponent
        else -> this.applicationContext.appComponent
    }