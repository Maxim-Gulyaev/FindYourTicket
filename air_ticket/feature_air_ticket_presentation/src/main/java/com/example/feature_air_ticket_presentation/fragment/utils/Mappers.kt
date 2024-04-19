package com.example.feature_air_ticket_presentation.fragment.utils

import com.example.feature_air_ticket_domain.model.MusicOfferDomain
import com.example.feature_air_ticket_domain.model.PriceDomain
import com.example.feature_air_ticket_presentation.fragment.ui.main_screen.model.MusicOffer
import com.example.feature_air_ticket_presentation.fragment.ui.main_screen.model.Price

/*fun List<MusicOfferDomain>.toMusicOffer(): List<MusicOffer> = this.map {
    MusicOffer(
        musicOfferId = it.musicOfferId,
        title = it.title,
        town = it.town,
        price = (it.price.toPrice())
    )
}*/

fun MusicOfferDomain.toMusicOffer(): MusicOffer =
    MusicOffer(
        musicOfferId = this.musicOfferId,
        title = this.title,
        town = this.town,
        price = (this.price.toPrice())
    )

fun PriceDomain.toPrice(): Price = Price(value = this.value)