package com.example.feature_air_ticket_data.repository

import com.example.feature_air_ticket_data.model.DirectFlightModel
import com.example.feature_air_ticket_data.model.MusicOfferModel
import com.example.feature_air_ticket_data.model.TicketModel

interface MainScreenRepository {

    fun getMusicOfferList(): List<MusicOfferModel>
    fun getDirectFlightList(): List<DirectFlightModel>
    fun getTicketList(): List<TicketModel>

}