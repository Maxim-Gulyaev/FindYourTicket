package com.example.feature_air_ticket_presentation.fragment.ui.all_tickets.model

import com.example.feature_air_ticket_presentation.fragment.ui.main_screen.model.Price

data class Ticket(
    val id: Int,
    val badge: String? = null,
    val price: Price,
    val providerName: String,
    val company: String,
    val departure: FlightInfo,
    val arrival: FlightInfo,
    val hasTransfer: Boolean,
    val hasVisaTransfer: Boolean,
    val luggage: Luggage,
    val handLuggage: HandLuggage,
    val isReturnable: Boolean,
    val isExchangeable: Boolean,
)
