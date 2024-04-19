package com.example.feature_air_ticket_domain.use_case.get_music_offer_list

import com.example.feature_air_ticket_domain.model.MusicOfferDomain
import kotlinx.coroutines.flow.Flow

interface GetMusicOfferListUseCase {
    fun execute(): Flow<MusicOfferDomain>
}