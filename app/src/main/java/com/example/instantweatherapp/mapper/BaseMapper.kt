package com.example.instantweatherapp.mapper

interface BaseMapper<E, D> {
    fun transformToDomain(type: E): D

    fun transformToDto(type: D): E // data transfer object

}