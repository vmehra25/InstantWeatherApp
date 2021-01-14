package com.example.instantweatherapp.data.source.local

import androidx.room.TypeConverter
import com.example.instantweatherapp.data.model.NetworkWeatherDescription
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class ListNetworkWeatherDescriptionConverter {
    val gson = Gson()
    val type: Type = object: TypeToken<List<NetworkWeatherDescription?>?>() {}.type

    @TypeConverter
    fun fromWeatherDToList(list: List<NetworkWeatherDescription?>?):String{
        return gson.toJson(list, type)
    }

    @TypeConverter
    fun toWeatherDFromList(json:String?):List<NetworkWeatherDescription>{
        return gson.fromJson(json, type)
    }
}