package com.example.instantweatherapp.data.model

import java.io.Serializable

data class NetworkWeatherDescription(
	val icon: String? = null,
	val description: String? = null,
	val main: String? = null,
	val id: Int? = null
):Serializable

