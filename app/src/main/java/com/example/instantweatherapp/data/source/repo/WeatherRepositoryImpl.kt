package com.example.instantweatherapp.data.source.repo

import com.example.instantweatherapp.data.model.Coord
import com.example.instantweatherapp.data.model.Weather
import com.example.instantweatherapp.data.model.WeatherForecast
import com.example.instantweatherapp.data.source.local.WeatherLocalDataSource
import com.example.instantweatherapp.data.source.local.WeatherLocalDataSourceImpl
import com.example.instantweatherapp.data.source.remote.WeatherRemoteDataSource
import com.example.instantweatherapp.data.source.remote.WeatherRemoteDataSourceImpl
import com.example.instantweatherapp.mapper.WeatherForecastMapperLocal
import com.example.instantweatherapp.mapper.WeatherForecastMapperRemote
import com.example.instantweatherapp.mapper.WeatherMapperLocal
import com.example.instantweatherapp.mapper.WeatherMapperRemote
import com.example.instantweatherapp.utils.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherRepositoryImpl(
        private val remoteDataSource: WeatherRemoteDataSourceImpl,
        private val localDataSource: WeatherLocalDataSourceImpl,
        private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): WeatherRepository {
    override suspend fun getWeather(coord: Coord, refresh: Boolean): Result<Weather> {
        return withContext(ioDispatcher) {
            if (refresh) {
                val mapper = WeatherMapperRemote()
                when (val response = remoteDataSource.getCurrentWeather(coord)) {
                    is Result.Success -> {
                        if (response.data != null) {
                            Result.Success(mapper.transformToDomain(response.data))
                        } else {
                            Result.Success(null)
                        }
                    }
                    is Result.Error -> {
                        Result.Error(response.e)
                    }
                    else -> Result.Loading
                }
            } else {
                val mapper = WeatherMapperLocal()
                val weather = localDataSource.getWeather()
                if (weather != null) {
                    Result.Success(mapper.transformToDomain(weather))
                } else {
                    Result.Success(null)
                }
            }
        }
    }

    override suspend fun getForecastWeather(
        cityId: Int,
        refresh: Boolean
    ): Result<List<WeatherForecast>> {
        return withContext(ioDispatcher){
            if(refresh){
                val mapperRemote = WeatherForecastMapperRemote()
                when(val response = remoteDataSource.getWeatherForecast(cityId)){
                    is Result.Success -> {
                        if(response.data != null){
                            Result.Success(mapperRemote.transformToDomain(response.data))
                        }else{
                            Result.Success(null)
                        }
                    }
                    is Result.Error -> {
                        Result.Error(response.e)
                    }
                    else -> {
                        Result.Loading
                    }
                }
            }else{
                val mapper = WeatherForecastMapperLocal()
                val listWeatherForecast = localDataSource.getAllWeatherForecast()
                Result.Success(mapper.transformToDomain(listWeatherForecast))
            }
        }
    }

    override suspend fun getSearchWeather(query: String): Result<Weather> {
        return withContext(ioDispatcher){
            val mapper = WeatherMapperRemote()
            when(val response = remoteDataSource.getSpecificWeather(query)){
                is Result.Success -> {
                    if(response.data != null){
                        Result.Success(mapper.transformToDomain(response.data))
                    }else{
                        Result.Success(null)
                    }
                }
                is Result.Error -> {
                    Result.Error(response.e)
                }
                else -> Result.Loading
            }
        }
    }

    override suspend fun insertWeather(weather: Weather) {
        withContext(ioDispatcher){
            val mapper = WeatherMapperLocal()
            localDataSource.insertWeather(mapper.transformToDto(weather))
        }
    }

    override suspend fun insertForecastWeather(weatherForecastList: List<WeatherForecast>) {
        withContext(ioDispatcher){
            val mapper = WeatherForecastMapperLocal()
            localDataSource.insertWeatherForecast(mapper.transformToDto(weatherForecastList))
        }
    }

    override suspend fun deleteWeatherData() {
        withContext(ioDispatcher){
            localDataSource.deleteAllWeather()
        }
    }

    override suspend fun deleteForecastData() {
        withContext(ioDispatcher){
            localDataSource.deleteAllWeatherForecast()
        }
    }
}