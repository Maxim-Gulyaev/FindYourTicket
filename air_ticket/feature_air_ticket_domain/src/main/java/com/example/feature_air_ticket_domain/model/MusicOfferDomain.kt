package com.example.feature_air_ticket_domain.model

data class MusicOfferDomain(
    val musicOfferId: Int,
    val title: String,
    val town: String,
    val price: PriceDomain,
)