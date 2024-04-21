package com.example.feature_air_ticket_domain.utils

import com.example.feature_air_ticket_data.model.DirectFlightModel
import com.example.feature_air_ticket_data.model.FlightInfoModel
import com.example.feature_air_ticket_data.model.HandLuggageModel
import com.example.feature_air_ticket_data.model.LuggageModel
import com.example.feature_air_ticket_data.model.MusicOfferModel
import com.example.feature_air_ticket_data.model.PriceModel
import com.example.feature_air_ticket_data.model.TicketModel
import com.example.feature_air_ticket_domain.model.DirectFlightDomain
import com.example.feature_air_ticket_domain.model.FlightInfoDomain
import com.example.feature_air_ticket_domain.model.HandLuggageDomain
import com.example.feature_air_ticket_domain.model.LuggageDomain
import com.example.feature_air_ticket_domain.model.MusicOfferDomain
import com.example.feature_air_ticket_domain.model.PriceDomain
import com.example.feature_air_ticket_domain.model.TicketDomain

fun List<MusicOfferModel>.toMusicOfferDomain(): List<MusicOfferDomain> =
    this.map {
        MusicOfferDomain(
            musicOfferId = it.id,
            title = it.title,
            town = it.town,
            price = it.price.toPriceDomain()
        )
    }

fun List<DirectFlightModel>.toDirectFlightDomain(): List<DirectFlightDomain> =
    this.map {
        DirectFlightDomain(
            id = it.id,
            title = it.title,
            timeRange = it.timeRange,
            price = it.price.toPriceDomain()
        )
    }

fun List<TicketModel>.toTicketDomain(): List<TicketDomain> =
    this.map {
        TicketDomain(
            id = it.id,
            badge = it.badge,
            price = it.price.toPriceDomain(),
            providerName = it.providerName,
            company = it.company,
            departure = it.departure.toFlightInfoDomain(),
            arrival = it.arrival.toFlightInfoDomain(),
            hasTransfer = it.hasTransfer,
            hasVisaTransfer = it.hasVisaTransfer,
            luggage = it.luggage.toLuggageDomain(),
            handLuggage = it.handLuggage.toHandLuggageDomain(),
            isReturnable = it.isReturnable,
            isExchangeable = it.isExchangeable
        )
    }

private fun PriceModel.toPriceDomain(): PriceDomain =
    PriceDomain(value = this.value)

private fun FlightInfoModel.toFlightInfoDomain(): FlightInfoDomain =
    FlightInfoDomain(
        town = this.town,
        date = this.date,
        airport = this.airport
    )

private fun HandLuggageModel.toHandLuggageDomain(): HandLuggageDomain =
    HandLuggageDomain(size = this.size)

private fun LuggageModel.toLuggageDomain(): LuggageDomain =
    LuggageDomain(price = this.price)
