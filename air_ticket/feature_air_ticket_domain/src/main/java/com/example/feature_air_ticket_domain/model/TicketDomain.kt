package com.example.feature_air_ticket_domain.model

data class TicketDomain(
    val id: Int,
    val badge: String? = null,
    val price: PriceDomain,
    val providerName: String,
    val company: String,
    val departure: FlightInfoDomain,
    val arrival: FlightInfoDomain,
    val hasTransfer: Boolean,
    val hasVisaTransfer: Boolean,
    val luggage: LuggageDomain,
    val handLuggage: HandLuggageDomain,
    val isReturnable: Boolean,
    val isExchangeable: Boolean,
)
