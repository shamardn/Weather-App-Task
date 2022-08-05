package com.shamardn.android.weathertask.data.domain

import com.google.gson.annotations.SerializedName

data class Temp(
    @SerializedName("day") val dayTemp: Double,
    @SerializedName("min") val minTemp: Double,
    @SerializedName("max") val maxTemp: Double,
)