package com.example.feature_air_ticket_data.model

import com.google.gson.annotations.SerializedName

data class DirectFlightModel(
    val id: Int,
    val title: String,
    @SerializedName("time_range")
    val timeRange: List<String>,
    val price: PriceModel,
)