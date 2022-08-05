package com.shamardn.android.weathertask.utils

import java.util.*

fun Long.formatDate(pattern: String): String{
    val simpleDateFormat = java.text.SimpleDateFormat(pattern)
    val date = Date(this * 1000)
    return simpleDateFormat.format(date)
}

fun String.extractCityName(): String{
    return this.split('/')[1]
}