package com.example.instantweatherapp.data.model

data class WeatherForecast(
    val uID: Int,

    val date: String,

    val wind: Wind,

    val networkWeatherDescription: List<NetworkWeatherDescription>,

    val networkWeatherCondition: NetworkWeatherCondition
)
