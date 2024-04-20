package com.example.feature_air_ticket_presentation.fragment.ui.show_flights.model

import com.example.feature_air_ticket_presentation.fragment.ui.main_screen.model.Price

data class DirectFlight(
    val id: Int,
    val title: String,
    val timeRange: List<String>,
    val price: Price,
)
