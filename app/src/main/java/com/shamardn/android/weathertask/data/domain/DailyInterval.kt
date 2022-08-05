package com.shamardn.android.weathertask.data.domain

import com.google.gson.annotations.SerializedName
import java.util.*

data class DailyInterval(
    val temp:Temp,
    @SerializedName("feels_like") val feelsLike: FeelsLike,
    @SerializedName("dt") val date: Long,
    val humidity: Int,
    @SerializedName("wind_speed") val wind: Double,
)