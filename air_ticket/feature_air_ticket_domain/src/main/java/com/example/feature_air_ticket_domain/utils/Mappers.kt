package com.example.feature_air_ticket_domain.utils

import com.example.feature_air_ticket_data.model.MusicOfferModel
import com.example.feature_air_ticket_data.model.PriceModel
import com.example.feature_air_ticket_domain.model.MusicOfferDomain
import com.example.feature_air_ticket_domain.model.PriceDomain

fun List<MusicOfferModel>.toMusicOfferDomain(): List<MusicOfferDomain> = this.map {
    MusicOfferDomain(
        musicOfferId = it.musicOfferId,
        title = it.title,
        town = it.town,
        price = (it.price.toPriceDomain()),
    )
}

private fun PriceModel.toPriceDomain(): PriceDomain = PriceDomain(value = this.value)