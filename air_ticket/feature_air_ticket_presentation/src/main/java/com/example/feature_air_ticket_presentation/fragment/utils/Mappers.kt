package com.example.feature_air_ticket_presentation.fragment.utils

import com.example.feature_air_ticket_domain.model.DirectFlightDomain
import com.example.feature_air_ticket_domain.model.MusicOfferDomain
import com.example.feature_air_ticket_domain.model.PriceDomain
import com.example.feature_air_ticket_presentation.fragment.ui.main_screen.model.MusicOffer
import com.example.feature_air_ticket_presentation.fragment.ui.main_screen.model.Price
import com.example.feature_air_ticket_presentation.fragment.ui.show_flights.model.DirectFlight

fun MusicOfferDomain.toMusicOffer(): MusicOffer =
    MusicOffer(
        musicOfferId = this.musicOfferId,
        title = this.title,
        town = this.town,
        price = this.price.toPrice()
    )

fun DirectFlightDomain.toDirectFlight(): DirectFlight =
    DirectFlight(
        id = this.id,
        title = this.title,
        timeRange = this.timeRange,
        price = this.price.toPrice()
    )

fun PriceDomain.toPrice(): Price = Price(value = this.value)