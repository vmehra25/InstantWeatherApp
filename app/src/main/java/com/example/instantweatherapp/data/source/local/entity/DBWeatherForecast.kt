package com.example.instantweatherapp.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.instantweatherapp.data.model.NetworkWeatherCondition
import com.example.instantweatherapp.data.model.NetworkWeatherDescription
import com.example.instantweatherapp.data.model.Wind

@Entity(tableName = "weather_forecast")
data class DBWeatherForecast(

    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,

    val date:String,

    @Embedded
    val wind: Wind,

    @ColumnInfo(name = "weather_description")
    val networkWeatherDescription: List<NetworkWeatherDescription>,

    @Embedded
    val networkWeatherCondition: NetworkWeatherCondition
)