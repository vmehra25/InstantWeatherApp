package com.example.instantweatherapp.utils

import java.lang.Exception

sealed class Result<out R>{
    data class Success<T>(val data:T?): Result<T>()
    // Covariance and Contravariant

    data class Error(val e: Exception): Result<Nothing>()

    object Loading:Result<Nothing>()

    override fun toString(): String {
        return when(this){
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$e]"
            is Loading -> "Loading"
        }
    }
}
