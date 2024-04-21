package com.example.feature_air_ticket_data.model

import com.google.gson.annotations.SerializedName

data class HandLuggageModel(
    @SerializedName("has_hand_luggage") val hasHandLuggage: Boolean,
    val size: String? = null
)