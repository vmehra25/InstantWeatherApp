package com.example.instantweatherapp.data.model

import java.io.Serializable

data class NetworkWeatherCondition(
	val temp: Double? = null,
	val tempMin: Double? = null,
	val humidity: Double? = null,
	val pressure: Double? = null,
	val feelsLike: Double? = null,
	val tempMax: Double? = null
):Serializable

