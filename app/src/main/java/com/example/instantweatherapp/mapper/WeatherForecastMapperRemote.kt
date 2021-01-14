package com.example.instantweatherapp.mapper

import com.example.instantweatherapp.data.model.NetworkWeatherDescription
import com.example.instantweatherapp.data.model.NetworkWeatherForecast
import com.example.instantweatherapp.data.model.WeatherForecast

class WeatherForecastMapperRemote:BaseMapper<List<NetworkWeatherForecast>, List<WeatherForecast>> {
    override fun transformToDomain(type: List<NetworkWeatherForecast>): List<WeatherForecast> {
        return type.map {
            WeatherForecast(
                it.id,
                it.date,
                it.wind,
                it.networkWeatherDescription,
                it.networkWeatherCondition
            )
        }
    }

    override fun transformToDto(type: List<WeatherForecast>): List<NetworkWeatherForecast> {
        return type.map {
            NetworkWeatherForecast(
                it.uID,
                it.date,
                it.wind,
                it.networkWeatherDescription,
                it.networkWeatherCondition
            )
        }
    }
}