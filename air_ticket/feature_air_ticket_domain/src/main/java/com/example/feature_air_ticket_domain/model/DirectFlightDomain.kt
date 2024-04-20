package com.example.feature_air_ticket_domain.model

data class DirectFlightDomain(
    val id: Int,
    val title: String,
    val timeRange: List<String>,
    val price: PriceDomain,
)