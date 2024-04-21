package com.example.feature_air_ticket_data.repository

import com.example.feature_air_ticket_data.data_source.MainScreenDataSourceImpl
import com.example.feature_air_ticket_data.model.DirectFlightModel
import com.example.feature_air_ticket_data.model.MusicOfferModel
import com.example.feature_air_ticket_data.model.TicketModel

class MainScreenRepositoryImpl(
    private val mainScreenDataSourceImpl: MainScreenDataSourceImpl
): MainScreenRepository {

    override fun getMusicOfferList(): List<MusicOfferModel> =
        mainScreenDataSourceImpl.getMusicOfferList()

    override fun getDirectFlightList(): List<DirectFlightModel> =
        mainScreenDataSourceImpl.getDirectFlightList()

    override fun getTicketList(): List<TicketModel> =
        mainScreenDataSourceImpl.getTicketList()

}