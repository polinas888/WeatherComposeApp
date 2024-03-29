package com.example.weathercomposeapp.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component(modules = [ModuleApp::class, ModuleDatabase::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }
}