package com.example.feature_air_ticket_data.repository

import com.example.feature_air_ticket_data.data_source.MainScreenDataSourceImpl
import com.example.feature_air_ticket_data.model.MusicOfferModel

class MainScreenRepositoryImpl(
    private val mainScreenDataSourceImpl: MainScreenDataSourceImpl
): MainScreenRepository {

    override fun getMusicOfferList(): List<MusicOfferModel> =
        mainScreenDataSourceImpl.getMusicOfferList()

}