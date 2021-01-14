package com.example.instantweatherapp.data.source.repo

import com.example.instantweatherapp.data.model.Coord
import com.example.instantweatherapp.data.model.Weather
import com.example.instantweatherapp.data.model.WeatherForecast
import com.example.instantweatherapp.utils.Result

interface WeatherRepository {
    suspend fun getWeather(coord: Coord, refresh:Boolean): Result<Weather>

    suspend fun getForecastWeather(cityId: Int, refresh: Boolean): Result<List<WeatherForecast>>

    suspend fun getSearchWeather(query:String): Result<Weather>

    suspend fun insertWeather(weather: Weather)

    suspend fun insertForecastWeather(weatherForecast: WeatherForecast)

    suspend fun deleteWeatherData()

    suspend fun deleteForecastData()
}