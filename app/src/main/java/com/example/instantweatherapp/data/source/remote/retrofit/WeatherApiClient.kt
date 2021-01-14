package com.example.instantweatherapp.data.source.remote.retrofit

import com.example.instantweatherapp.data.source.remote.retrofit.ApiEndPoints.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WeatherApiClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val retrofitService: WeatherApiService by lazy{
        retrofit.create(WeatherApiService::class.java)
    }
}