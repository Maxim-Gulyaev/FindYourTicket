package com.example.feature_air_ticket_di.module

import com.example.feature_air_ticket_data.repository.MainScreenRepository
import com.example.feature_air_ticket_domain.use_case.get_direct_flight_list.GetDirectFlightListUseCase
import com.example.feature_air_ticket_domain.use_case.get_direct_flight_list.GetDirectFlightListUseCaseImpl
import com.example.feature_air_ticket_domain.use_case.get_music_offer_list.GetMusicOfferListUseCase
import com.example.feature_air_ticket_domain.use_case.get_music_offer_list.GetMusicOfferListUseCaseImpl
import com.example.feature_air_ticket_domain.use_case.get_ticket_list.GetTicketListUseCase
import com.example.feature_air_ticket_domain.use_case.get_ticket_list.GetTicketListUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
class AirTicketDomainModule {

    @Provides
    fun providesGetMusicOfferListUseCase(
        mainScreenRepository: MainScreenRepository
    ): GetMusicOfferListUseCase =
        GetMusicOfferListUseCaseImpl(
            mainScreenRepository = mainScreenRepository
        )

    @Provides
    fun providesGetDirectFlightListUseCase(
        mainScreenRepository: MainScreenRepository
    ): GetDirectFlightListUseCase =
        GetDirectFlightListUseCaseImpl(
            mainScreenRepository = mainScreenRepository
        )

    @Provides
    fun providesGetTicketListUseCase(
        mainScreenRepository: MainScreenRepository
    ): GetTicketListUseCase =
        GetTicketListUseCaseImpl(
            mainScreenRepository = mainScreenRepository
        )

}