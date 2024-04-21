package com.example.feature_air_ticket_presentation.fragment.utils

import com.example.feature_air_ticket_domain.model.DirectFlightDomain
import com.example.feature_air_ticket_domain.model.FlightInfoDomain
import com.example.feature_air_ticket_domain.model.HandLuggageDomain
import com.example.feature_air_ticket_domain.model.LuggageDomain
import com.example.feature_air_ticket_domain.model.MusicOfferDomain
import com.example.feature_air_ticket_domain.model.PriceDomain
import com.example.feature_air_ticket_domain.model.TicketDomain
import com.example.feature_air_ticket_presentation.fragment.ui.all_tickets.model.FlightInfo
import com.example.feature_air_ticket_presentation.fragment.ui.all_tickets.model.HandLuggage
import com.example.feature_air_ticket_presentation.fragment.ui.all_tickets.model.Luggage
import com.example.feature_air_ticket_presentation.fragment.ui.all_tickets.model.Ticket
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

fun TicketDomain.toTicket(): Ticket =
    Ticket(
        id = this.id,
        badge = this.badge,
        price = this.price.toPrice(),
        providerName = this.providerName,
        company = this.company,
        departure = this.departure.toFlightInfo(),
        arrival = this.arrival.toFlightInfo(),
        hasTransfer = this.hasTransfer,
        hasVisaTransfer = this.hasVisaTransfer,
        luggage = this.luggage.toLuggage(),
        handLuggage = this.handLuggage.toHandLuggage(),
        isReturnable = this.isReturnable,
        isExchangeable = this.isExchangeable
    )

fun PriceDomain.toPrice(): Price = Price(value = this.value)

private fun FlightInfoDomain.toFlightInfo(): FlightInfo =
    FlightInfo(
        town = this.town,
        date = this.date,
        airport = this.airport
    )

private fun HandLuggageDomain.toHandLuggage(): HandLuggage =
    HandLuggage(size = this.size)

private fun LuggageDomain.toLuggage(): Luggage =
    Luggage(price = this.price)