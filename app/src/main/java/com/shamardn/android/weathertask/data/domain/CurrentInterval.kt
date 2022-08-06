package com.shamardn.android.weathertask.data.domain

import com.google.gson.annotations.SerializedName
import java.util.*

data class CurrentInterval(
    @SerializedName("dt") val today: Long,
    val temp: Double,
    val humidity: Double,
    @SerializedName("wind_speed") val wind: Double,
    @SerializedName("sunrise") val sunrise: Long,
    @SerializedName("sunset") val sunset: Long,
    val weather: List<WeatherCode>

    )