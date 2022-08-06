package com.shamardn.android.weathertask.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shamardn.android.weathertask.R
import com.shamardn.android.weathertask.data.domain.Interval
import com.shamardn.android.weathertask.databinding.ItemDailyBinding
import com.shamardn.android.weathertask.databinding.ItemHeaderBinding
import com.shamardn.android.weathertask.utils.extractCityName
import com.shamardn.android.weathertask.utils.formatDate
import com.shamardn.android.weathertask.utils.setImageToWeatherDesc

class WeatherAdapter(val interval: Interval): RecyclerView.Adapter<WeatherAdapter.BaseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when(viewType){
            TYPE_HEADER -> {
                HeaderViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_header,parent,false))
            }
            TYPE_WEATHER -> {
                WeatherViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_daily,parent,false))
            }
            else -> super.createViewHolder(parent,viewType)

        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {

        when(holder){
            is HeaderViewHolder -> {
                val dailyInterval = interval.daily[position]
                holder.binding.apply {
                    tvCity.text = interval.city.extractCityName()
                    tvToday.text = interval.current.today.formatDate("EEE MMM, dd")
                    tvFeelLike.text = "${interval.current.temp.toInt()}°C"
                    tvHumidityValue.text = "${interval.current.humidity.toString()}%"
                    tvWindValue.text = "${interval.current.wind}m/s"
                    tvSunriseTime.text = interval.current.sunrise.formatDate("h:mm a")
                    tvSunsetTime.text = interval.current.sunset.formatDate("h:mm a")

                   val code = interval.current.weather[position].description
                    Glide.with(root).load(code.setImageToWeatherDesc()).into(ivWeatherCode)
                }
            }
            is WeatherViewHolder -> {
                val dailyInterval = interval.daily[position-1]
                holder.binding.apply {
                    tvAvgDay1.text = "${dailyInterval.temp.minTemp.toInt()}~${dailyInterval.temp.maxTemp.toInt()}°C"
                    tvTempDay1.text = "${dailyInterval.feelsLike.day.toInt()}°C"
                    tvDateDay1.text = dailyInterval.date.formatDate("MMM dd")
                    tvHumidityValueDay1.text = "${dailyInterval.humidity}%"
                    tvWindValueDay1.text = "${dailyInterval.wind.toInt()}m/s"

                    val code = dailyInterval.weather[0].description
                    Glide.with(root).load(code.setImageToWeatherDesc()).into(ivWeather)
            }
        }

        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(position){
            0 -> TYPE_HEADER
            else -> TYPE_WEATHER
        }
    }

    override fun getItemCount() = interval.daily.size + 1

    abstract class BaseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    class WeatherViewHolder(itemView: View): BaseViewHolder(itemView) {
        val binding = ItemDailyBinding.bind(itemView)
    }

    class HeaderViewHolder(itemView: View): BaseViewHolder(itemView) {
        val binding = ItemHeaderBinding.bind(itemView)
    }

    companion object{
        const val TYPE_HEADER = 111
        const val TYPE_WEATHER = 222
    }
}