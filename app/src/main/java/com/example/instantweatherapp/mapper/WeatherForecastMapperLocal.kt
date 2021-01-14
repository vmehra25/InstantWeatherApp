package com.example.instantweatherapp.mapper

import com.example.instantweatherapp.data.model.WeatherForecast
import com.example.instantweatherapp.data.source.local.entity.DBWeatherForecast

class WeatherForecastMapperLocal: BaseMapper<List<DBWeatherForecast>, List<WeatherForecast>> {
    override fun transformToDomain(type: List<DBWeatherForecast>): List<WeatherForecast> {
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

    override fun transformToDto(type: List<WeatherForecast>): List<DBWeatherForecast> {
        return type.map {
            DBWeatherForecast(
                it.uID,
                it.date,
                it.wind,
                it.networkWeatherDescription,
                it.networkWeatherCondition
            )
        }
    }

}