package com.example.feature_air_ticket_data.model

data class MusicOfferModel(
    val musicOfferId: Int,
    val title: String,
    val town: String,
    val price: PriceModel,
)
