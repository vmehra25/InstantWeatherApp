package com.example.instantweatherapp.data.source.repo

import com.example.instantweatherapp.data.model.Coord
import com.example.instantweatherapp.data.model.Weather
import com.example.instantweatherapp.data.model.WeatherForecast
import com.example.instantweatherapp.data.source.local.WeatherLocalDataSource
import com.example.instantweatherapp.data.source.remote.WeatherRemoteDataSource
import com.example.instantweatherapp.mapper.WeatherMapperLocal
import com.example.instantweatherapp.mapper.WeatherMapperRemote
import com.example.instantweatherapp.utils.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherRepositoryImpl(
    private val remoteDataSource: WeatherRemoteDataSource,
    private val localDataSource: WeatherLocalDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): WeatherRepository {
    override suspend fun getWeather(coord: Coord, refresh: Boolean): Result<Weather> {
        withContext(ioDispatcher){
            if(refresh){
                val mapper = WeatherMapperRemote()
                when(val response = remoteDataSource.getCurrentWeather(coord)){
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
            }else{
                val mapper = WeatherMapperLocal()
                val weather = localDataSource.getWeather()
                if(weather != null){
                    Result.Success(mapper.transformToDomain(weather))
                }else{
                    Result.Success(null)
                }
            }
        }
    }

    override suspend fun getForecastWeather(
        cityId: Int,
        refresh: Boolean
    ): Result<List<WeatherForecast>> {
        TODO("Not yet implemented")
    }

    override suspend fun getSearchWeather(query: String): Result<Weather> {
        TODO("Not yet implemented")
    }

    override suspend fun insertWeather(weather: Weather) {
        TODO("Not yet implemented")
    }

    override suspend fun insertForecastWeather(weatherForecast: WeatherForecast) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteWeatherData() {
        TODO("Not yet implemented")
    }

    override suspend fun deleteForecastData() {
        TODO("Not yet implemented")
    }
}