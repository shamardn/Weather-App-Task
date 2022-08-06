package com.shamardn.android.weathertask.utils

import com.shamardn.android.weathertask.R
import java.util.*

fun Long.formatDate(pattern: String): String{
    val simpleDateFormat = java.text.SimpleDateFormat(pattern)
    val date = Date(this * 1000)
    return simpleDateFormat.format(date)
}

fun String.extractCityName(): String{
    return this.split('/')[1]
}

fun String.setImageToWeatherDesc(): Int{
    return when(this){
        "thunderstorm" -> R.drawable.ic_thunder_storm
        "rain", "shower rain" -> R.drawable.ic_rains
        "snow" -> R.drawable.ic_snow
        "mist" -> R.drawable.ic_mist
        "clear sky" -> R.drawable.ic_clear_day
        "few clouds", "scattered clouds","broken clouds", "overcast clouds" -> R.drawable.ic_cloudy
        else -> R.drawable.ic_clear_night
    }
}