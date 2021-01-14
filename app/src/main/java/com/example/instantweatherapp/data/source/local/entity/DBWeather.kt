package com.example.instantweatherapp.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.instantweatherapp.data.model.NetworkWeatherCondition
import com.example.instantweatherapp.data.model.NetworkWeatherDescription
import com.example.instantweatherapp.data.model.Wind

// table name is given
@Entity(tableName = "weather_table")
data class DBWeather(

    // name of column will now be unique_id instead of uId
    @ColumnInfo(name = "unique_id")
    @PrimaryKey(autoGenerate = true)
    val uId:Int = 0,

    @ColumnInfo(name = "city_id")
    val cityId:Int,

    @ColumnInfo(name = "city_name")
    val cityName:String,

    // enables to save nested class, our own class / non trivial
    @Embedded
    val wind:Wind,

    @ColumnInfo(name = "weather_details")
    val networkWeatherDescription: List<NetworkWeatherDescription>,

    @Embedded
    val networkWeatherCondition: NetworkWeatherCondition
)