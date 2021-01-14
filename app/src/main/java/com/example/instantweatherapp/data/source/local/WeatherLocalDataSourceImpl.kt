package com.example.instantweatherapp.data.source.local

import com.example.instantweatherapp.data.source.local.dao.WeatherDao
import com.example.instantweatherapp.data.source.local.entity.DBWeather
import com.example.instantweatherapp.data.source.local.entity.DBWeatherForecast
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherLocalDataSourceImpl(
    private val weatherDao: WeatherDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
):WeatherLocalDataSource {
    override suspend fun getWeather(): DBWeather?  = withContext(ioDispatcher){
        return@withContext weatherDao.getWeather()
    }

    override suspend fun insertWeather(weather: DBWeather) = withContext(ioDispatcher){
        weatherDao.insertWeather(weather)
    }

    override suspend fun getWeatherList(): List<DBWeather>? = withContext(ioDispatcher){
        return@withContext weatherDao.getWeatherList()
    }

    override suspend fun deleteAllWeather() = withContext(ioDispatcher){
        weatherDao.deleteAllWeather()
    }

    override suspend fun insertWeatherForecast(dbWeatherForecast: DBWeatherForecast) = withContext(ioDispatcher){
        weatherDao.insertWeatherForecast(dbWeatherForecast)
    }

    override suspend fun getAllWeatherForecast(): List<DBWeatherForecast> = withContext(ioDispatcher){
        return@withContext weatherDao.getAllWeatherForecast()
    }

    override suspend fun deleteAllWeatherForecast() = withContext(ioDispatcher){
        weatherDao.deleteAllWeatherForecast()
    }
}