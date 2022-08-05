package com.shamardn.android.weathertask.data.network

import android.util.Log
import com.google.gson.Gson
import com.shamardn.android.weathertask.data.DataManager
import com.shamardn.android.weathertask.data.domain.Interval
import com.shamardn.android.weathertask.utils.Constants
import okhttp3.*
import java.io.IOException

class Client(val dataManager: DataManager) {
    val client = OkHttpClient()

    fun makeRequestWithOkHTTP(setupRecycler: () -> Unit) {
        val request = Request.Builder().url(Constants.URL).build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.i(Constants.TAG, "fail: ${e.message}")
            }
            override fun onResponse(call: Call, response: Response) {
                response.body?.string().let { jsonString ->
                    val result = Gson().fromJson(jsonString, Interval::class.java)
                    dataManager.setIntervalData(result)
                    Log.i(Constants.TAG, "$result")
                }
                setupRecycler()
            }

        })
    }
}