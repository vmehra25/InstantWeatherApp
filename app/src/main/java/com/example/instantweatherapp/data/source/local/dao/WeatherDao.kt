package com.example.instantweatherapp.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.instantweatherapp.data.source.local.entity.DBWeather
import com.example.instantweatherapp.data.source.local.entity.DBWeatherForecast


@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeather(vararg dbWeather: DBWeather)

    @Query("SELECT * FROM weather_table order by unique_id desc limit 1")
    suspend fun getWeather(): DBWeather

    @Query("select * from weather_table order by unique_id desc")
    suspend fun getWeatherList():List<DBWeather>

    @Query("delete from weather_table")
    suspend fun deleteAllWeather()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeatherForecast(vararg dbWeatherForecast: DBWeatherForecast)

    @Query("select * from weather_forecast order by id")
    suspend fun getAllWeatherForecast(): List<DBWeatherForecast>

    @Query("delete from weather_forecast")
    suspend fun deleteAllWeatherForecast()

}