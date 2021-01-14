package com.example.instantweatherapp.data.source.local

import com.example.instantweatherapp.data.source.local.entity.DBWeather
import com.example.instantweatherapp.data.source.local.entity.DBWeatherForecast

interface WeatherLocalDataSource {
    suspend fun getWeather(): DBWeather?

    suspend fun insertWeather(weather: DBWeather)

    suspend fun getWeatherList():List<DBWeather>?

    suspend fun deleteAllWeather()

    suspend fun insertWeatherForecast(dbWeatherForecast: List<DBWeatherForecast>)

    suspend fun getAllWeatherForecast(): List<DBWeatherForecast>

    suspend fun deleteAllWeatherForecast()
}