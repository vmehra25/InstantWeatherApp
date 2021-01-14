package com.example.instantweatherapp.data.model

import java.io.Serializable

data class Weather(
    val uId: Int,
    val cityId: Int,
    val name: String,
    val wind: Wind,
    val networkWeatherDescription: List<NetworkWeatherDescription>,
    val networkWeatherCondition: NetworkWeatherCondition
) : Serializable
