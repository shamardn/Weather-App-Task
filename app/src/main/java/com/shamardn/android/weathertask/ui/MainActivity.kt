package com.shamardn.android.weathertask.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shamardn.android.weathertask.data.DataManager
import com.shamardn.android.weathertask.data.domain.Interval
import com.shamardn.android.weathertask.data.network.Client
import com.shamardn.android.weathertask.databinding.ActivityMainBinding
import com.shamardn.android.weathertask.utils.extractCityName
import com.shamardn.android.weathertask.utils.formatDate
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val dataManager = DataManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }


    private fun setup() {
        makeRequest()
    }

    private fun makeRequest() {
        val okHttp = Client(dataManager)
        okHttp.makeRequestWithOkHTTP {
            runOnUiThread {
                callBack(dataManager.intervalData!!)
            }
        }
    }

    private fun callBack(interval: Interval) {
        val weatherAdapter = WeatherAdapter(interval)
        binding.rvDailyWeather.adapter = weatherAdapter
    }

}