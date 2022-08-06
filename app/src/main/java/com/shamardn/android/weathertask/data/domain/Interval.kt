package com.shamardn.android.weathertask.data.domain

import com.google.gson.annotations.SerializedName

data class Interval(
    @SerializedName("timezone") val city: String,
    val current:CurrentInterval,
    val daily:List<DailyInterval>,
    @SerializedName("dt")val date: Long,

    )
