package com.example.instantweatherapp.data.source.remote

import com.example.instantweatherapp.BuildConfig
import com.example.instantweatherapp.data.model.Coord
import com.example.instantweatherapp.data.model.NetworkWeather
import com.example.instantweatherapp.data.model.NetworkWeatherForecast
import com.example.instantweatherapp.data.source.remote.retrofit.WeatherApiClient
import com.example.instantweatherapp.data.source.remote.retrofit.WeatherApiService
import com.example.instantweatherapp.utils.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

class WeatherRemoteDataSourceImpl(
    private val ioDispatcher:CoroutineDispatcher = Dispatchers.IO,
    private val retrofitClient: WeatherApiService = WeatherApiClient.retrofitService
): WeatherRemoteDataSource {
    override suspend fun getCurrentWeather(coord: Coord): Result<NetworkWeather> {
        return withContext(ioDispatcher) {
            return@withContext try {
                val result = retrofitClient.getCurrentWeather(
                    coord.lat!!,
                    coord.lon!!,
                    BuildConfig.API_KEY
                )
                if (result.isSuccessful) {
                    val networkWeather = result.body()
                    Result.Success(networkWeather)
                } else {
                    Result.Success(null)
                }
            } catch (exception: Exception) {
                Result.Error(exception)
            }
        }
    }

    override suspend fun getSpecificWeather(query: String): Result<NetworkWeather> {
        return withContext(ioDispatcher){
            return@withContext try{
                val result =  retrofitClient.getSpecificWeather(query, BuildConfig.API_KEY)
                if(result.isSuccessful){
                    val networkWeather = result.body()
                    Result.Success(networkWeather)
                }else{
                    Result.Success(null)
                }
            }
            catch (exception: Exception){
                Result.Error(exception)
            }
        }
    }

    override suspend fun getWeatherForecast(cityId: Int): Result<List<NetworkWeatherForecast>> {
        return withContext(ioDispatcher){
            return@withContext try {
                val result = retrofitClient.getWeatherForecast(cityId, BuildConfig.API_KEY)
                if(result.isSuccessful){
                    val networkWeatherForecast = result.body()?.weathers
                    Result.Success(networkWeatherForecast)
                }else{
                    Result.Success(null)
                }
            }
            catch (exception: Exception){
                Result.Error(exception)
            }
        }
    }
}