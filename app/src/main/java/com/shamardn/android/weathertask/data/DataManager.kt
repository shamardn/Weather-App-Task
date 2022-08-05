package com.shamardn.android.weathertask.data

import android.util.Log
import com.shamardn.android.weathertask.data.domain.DailyInterval
import com.shamardn.android.weathertask.data.domain.Interval

class DataManager {
    private var _intervalData : Interval? = null


    val intervalData : Interval?
        get() = _intervalData

    fun setIntervalData(interval: Interval) {
        _intervalData = interval
        Log.i(TAG, "data saved: $_intervalData")
    }

    companion object {
        val TAG = "DataManager"
    }
}
