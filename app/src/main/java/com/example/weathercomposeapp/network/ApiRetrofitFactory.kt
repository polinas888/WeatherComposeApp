package com.example.weathercomposeapp.network

import com.example.weathercomposeapp.BuildConfig
import com.example.weathercomposeapp.utils.Constants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiRetrofitFactory {
    private val authInterceptor = Interceptor { chain ->
        val newUrl = chain.request().url
            .newBuilder()
            .addQueryParameter("appid", BuildConfig.API_KEY)
            .build()

        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()

        chain.proceed(newRequest)
    }

    private val httpClient = OkHttpClient().newBuilder()
        .addInterceptor(authInterceptor)
        .build()

    fun weatherApiRetrofit(): Retrofit = Retrofit.Builder()
        .client(httpClient)
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}