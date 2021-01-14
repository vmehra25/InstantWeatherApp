package com.example.instantweatherapp.mapper

import com.example.instantweatherapp.data.model.NetworkWeather
import com.example.instantweatherapp.data.model.Weather

class WeatherMapperRemote: BaseMapper<NetworkWeather, Weather> {
    override fun transformToDomain(type: NetworkWeather): Weather {
        return Weather(
            type.uId,
            type.cityId,
            type.name,
            type.wind,
            type.networkWeatherDescription,
            type.networkWeatherCondition
        )
    }

    override fun transformToDto(type: Weather): NetworkWeather {
        return NetworkWeather(
            type.uId,
            type.cityId,
            type.name,
            type.wind,
            type.networkWeatherDescription,
            type.networkWeatherCondition
        )
    }

}