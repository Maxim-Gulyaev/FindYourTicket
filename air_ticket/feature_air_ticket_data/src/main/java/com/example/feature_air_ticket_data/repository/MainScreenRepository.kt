package com.example.feature_air_ticket_data.repository

import com.example.feature_air_ticket_data.model.MusicOfferModel

interface MainScreenRepository {
    fun getMusicOfferList(): List<MusicOfferModel>
}