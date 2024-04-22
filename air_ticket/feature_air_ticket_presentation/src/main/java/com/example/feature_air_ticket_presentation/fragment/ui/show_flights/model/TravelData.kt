package com.example.feature_air_ticket_presentation.fragment.ui.show_flights.model

import java.io.Serializable

data class TravelData(
    val departure: String,
    val destination: String,
    val departureDate: Long
) : Serializable
