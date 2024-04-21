package com.example.feature_air_ticket_data.model

import com.google.gson.annotations.SerializedName

data class TicketModel(
    val id: Int,
    val badge: String? = null,
    val price: PriceModel,
    @SerializedName("provider_name") val providerName: String,
    val company: String,
    val departure: FlightInfoModel,
    val arrival: FlightInfoModel,
    @SerializedName("has_transfer") val hasTransfer: Boolean,
    @SerializedName("has_visa_transfer") val hasVisaTransfer: Boolean,
    val luggage: LuggageModel,
    @SerializedName("hand_luggage") val handLuggage: HandLuggageModel,
    @SerializedName("is_returnable") val isReturnable: Boolean,
    @SerializedName("is_exchangable") val isExchangeable: Boolean,
)
