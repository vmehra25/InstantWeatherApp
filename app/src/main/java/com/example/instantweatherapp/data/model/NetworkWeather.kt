package com.example.instantweatherapp.data.model

import com.google.gson.annotations.SerializedName

data class NetworkWeather(
	val uId: Int,
	@SerializedName("id")
	val cityId: Int,
	val name: String,
	val wind: Wind,
	@SerializedName("weather")
	val networkWeatherDescription: List<NetworkWeatherDescription>,
	@SerializedName("main")
	val networkWeatherCondition: NetworkWeatherCondition
//	val visibility: Int? = null,
//	val timezone: Int? = null,
//	val clouds: Clouds? = null,
//	val sys: Sys? = null,
//	val dt: Int? = null,
//	val coord: Coord? = null,
//	val cod: Int? = null,
//	val base: String? = null
)


