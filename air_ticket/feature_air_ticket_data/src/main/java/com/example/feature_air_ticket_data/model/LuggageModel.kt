package com.example.feature_air_ticket_data.model

import com.google.gson.annotations.SerializedName

data class LuggageModel(
    @SerializedName("has_luggage") val hasLuggage: Boolean,
    val price: PriceModel? = null
)