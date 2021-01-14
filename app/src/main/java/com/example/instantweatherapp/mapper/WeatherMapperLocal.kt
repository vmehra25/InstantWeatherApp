package com.example.instantweatherapp.mapper

import com.example.instantweatherapp.data.model.Weather
import com.example.instantweatherapp.data.source.local.entity.DBWeather

class WeatherMapperLocal:BaseMapper<DBWeather, Weather> {
    override fun transformToDomain(type: DBWeather): Weather {
        return Weather(
            type.uId,
            type.cityId,
            type.cityName,
            type.wind,
            type.networkWeatherDescription,
            type.networkWeatherCondition
        )
    }

    override fun transformToDto(type: Weather): DBWeather {
        return DBWeather(
            type.uId,
            type.cityId,
            type.name,
            type.wind,
            type.networkWeatherDescription,
            type.networkWeatherCondition
        )
    }

}