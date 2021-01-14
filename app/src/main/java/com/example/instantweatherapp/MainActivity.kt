package com.example.instantweatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.instantweatherapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        _binding = ActivityMainBinding.inflate(layoutInflater)

    }
}