package com.example.feature_air_ticket_domain.use_case.get_music_offer_list

import com.example.feature_air_ticket_data.repository.MainScreenRepository
import com.example.feature_air_ticket_domain.model.MusicOfferDomain
import com.example.feature_air_ticket_domain.utils.toMusicOfferDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import javax.inject.Inject

class GetMusicOfferListUseCaseImpl @Inject constructor(
    private val mainScreenRepository: MainScreenRepository
): GetMusicOfferListUseCase {

    override fun execute(): Flow<MusicOfferDomain> =
        mainScreenRepository.getMusicOfferList().toMusicOfferDomain().asFlow()

}