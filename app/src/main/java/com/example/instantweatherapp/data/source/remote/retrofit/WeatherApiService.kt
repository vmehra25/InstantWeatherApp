package com.example.instantweatherapp.data.source.remote.retrofit

import com.example.instantweatherapp.data.model.NetworkWeather
import com.example.instantweatherapp.data.model.NetworkWeatherForecastResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("/data/2.5/weather")
    suspend fun getSpecificWeather(
        @Query("q") location:String,
        @Query("appid") apiKey:String
    ):Response<NetworkWeather>

    @GET("/data/2.5/weather")
    suspend fun getCurrentWeather(
        @Query("lat") lat:Double,
        @Query("lon") lon:Double,
        @Query("appid") apiKey:String
    ):Response<NetworkWeather>

    @GET("/data/2.5/forecast")
    suspend fun getWeatherForecast(
        @Query("id") cityId:Int,
        @Query("appid") apiKey: String
    ):Response<NetworkWeatherForecastResponse>
}