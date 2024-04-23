package com.example.feature_air_ticket_presentation.fragment.di

import com.example.feature_air_ticket_data.repository.MainScreenRepositoryImpl
import com.example.feature_air_ticket_domain.use_case.get_direct_flight_list.GetDirectFlightListUseCaseImpl
import com.example.feature_air_ticket_domain.use_case.get_music_offer_list.GetMusicOfferListUseCaseImpl
import com.example.feature_air_ticket_domain.use_case.get_ticket_list.GetTicketListUseCaseImpl
import com.example.feature_air_ticket_presentation.fragment.ui.all_tickets.AllTicketsFragment
import com.example.feature_air_ticket_presentation.fragment.ui.all_tickets.AllTicketsViewModel
import com.example.feature_air_ticket_presentation.fragment.ui.main_screen.AirTicketsMainFragment
import com.example.feature_air_ticket_presentation.fragment.ui.main_screen.AirTicketsMainViewModel
import com.example.feature_air_ticket_presentation.fragment.ui.show_flights.ShowFlightsFragment
import com.example.feature_air_ticket_presentation.fragment.ui.show_flights.ShowFlightsViewModel

interface ComponentProvider {

    /*fun inject(mainScreenRepositoryImpl: MainScreenRepositoryImpl)
    fun inject(getDirectFlightListUseCaseImpl: GetDirectFlightListUseCaseImpl)
    fun inject(getMusicOfferListUseCaseImpl: GetMusicOfferListUseCaseImpl)
    fun inject(getTicketListUseCaseImpl: GetTicketListUseCaseImpl)
    fun inject(allTicketsViewModel: AllTicketsViewModel)
    fun inject(airTicketsMainViewModel: AirTicketsMainViewModel)
    fun inject(showFlightsViewModel: ShowFlightsViewModel)*/
    fun inject(fragment: AllTicketsFragment)
    fun inject(fragment: AirTicketsMainFragment)
    fun inject(fragment: ShowFlightsFragment)

}