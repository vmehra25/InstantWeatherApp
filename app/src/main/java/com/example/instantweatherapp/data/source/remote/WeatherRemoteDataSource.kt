package com.example.instantweatherapp.data.source.remote

import com.example.instantweatherapp.data.model.Coord
import com.example.instantweatherapp.data.model.NetworkWeather
import com.example.instantweatherapp.data.model.NetworkWeatherForecast
import com.example.instantweatherapp.data.model.NetworkWeatherForecastResponse
import com.example.instantweatherapp.utils.Result

interface WeatherRemoteDataSource {
    suspend fun getCurrentWeather(coord :Coord): Result<NetworkWeather>

    suspend fun getSpecificWeather(query:String): Result<NetworkWeather>

    suspend fun getWeatherForecast(cityId: Int): Result<List<NetworkWeatherForecast> >
}