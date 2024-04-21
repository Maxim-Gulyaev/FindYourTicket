package com.example.feature_air_ticket_data.data_source

import com.example.feature_air_ticket_data.model.DirectFlightModel
import com.example.feature_air_ticket_data.model.MusicOfferModel
import com.example.feature_air_ticket_data.model.TicketModel

interface MainScreenDataSource {

    fun getMusicOfferList(): List<MusicOfferModel>
    fun getDirectFlightList(): List<DirectFlightModel>
    fun getTicketList(): List<TicketModel>

}