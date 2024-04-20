package com.example.feature_air_ticket_domain.use_case.get_music_offer_list

import com.example.feature_air_ticket_data.repository.MainScreenRepositoryImpl
import com.example.feature_air_ticket_domain.model.MusicOfferDomain
import com.example.feature_air_ticket_domain.utils.toMusicOfferDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

class GetMusicOfferListUseCaseImpl(
    private val mainScreenRepositoryImpl: MainScreenRepositoryImpl
): GetMusicOfferListUseCase {

    override fun execute(): Flow<MusicOfferDomain> =
        mainScreenRepositoryImpl.getMusicOfferList().toMusicOfferDomain().asFlow()

}