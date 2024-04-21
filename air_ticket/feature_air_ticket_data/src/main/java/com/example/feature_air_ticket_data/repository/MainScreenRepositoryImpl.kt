package com.example.feature_air_ticket_data.repository

import com.example.feature_air_ticket_data.data_source.MainScreenDataSource
import com.example.feature_air_ticket_data.model.DirectFlightModel
import com.example.feature_air_ticket_data.model.MusicOfferModel
import com.example.feature_air_ticket_data.model.TicketModel
import javax.inject.Inject

class MainScreenRepositoryImpl @Inject constructor(
    private val mainScreenDataSource: MainScreenDataSource
): MainScreenRepository {

    override fun getMusicOfferList(): List<MusicOfferModel> =
        mainScreenDataSource.getMusicOfferList()

    override fun getDirectFlightList(): List<DirectFlightModel> =
        mainScreenDataSource.getDirectFlightList()

    override fun getTicketList(): List<TicketModel> =
        mainScreenDataSource.getTicketList()

}