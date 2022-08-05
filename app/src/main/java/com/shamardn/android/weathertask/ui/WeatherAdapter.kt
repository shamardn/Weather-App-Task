package com.shamardn.android.weathertask.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shamardn.android.weathertask.R
import com.shamardn.android.weathertask.data.domain.DailyInterval
import com.shamardn.android.weathertask.data.domain.Interval
import com.shamardn.android.weathertask.databinding.ItemDailyBinding
import com.shamardn.android.weathertask.utils.formatDate

class WeatherAdapter(val interval: Interval): RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
       return WeatherViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_daily,parent,false))
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val dailyInterval = interval.daily[position]
        holder.binding.apply {
            tvAvgDay1.text = "${dailyInterval.temp.minTemp.toInt()}~${dailyInterval.temp.maxTemp.toInt()}°C"
            tvTempDay1.text = "${dailyInterval.feelsLike.day.toInt()}°C"
            tvDateDay1.text = dailyInterval.date.formatDate("MMM dd")
            tvHumidityValueDay1.text = "${dailyInterval.humidity}%"
            tvWindValueDay1.text = "${dailyInterval.wind.toInt()}m/s"
        }

    }

    override fun getItemCount() = interval.daily.size

    class WeatherViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = ItemDailyBinding.bind(itemView)
    }
}