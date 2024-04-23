package com.example.feature_air_ticket_di.component

import com.example.feature_air_ticket_di.module.AirTicketDataModule
import com.example.feature_air_ticket_di.module.AirTicketDomainModule
import com.example.feature_air_ticket_di.module.AirTicketPresentationModule
import com.example.feature_air_ticket_di.scope.AirTicketScope
import com.example.feature_air_ticket_presentation.fragment.ui.all_tickets.AllTicketsFragment
import com.example.feature_air_ticket_presentation.fragment.ui.main_screen.AirTicketsMainFragment
import com.example.feature_air_ticket_presentation.fragment.ui.show_flights.ShowFlightsFragment
import dagger.Component

@AirTicketScope
@Component(
    modules = [
        AirTicketDataModule::class,
        AirTicketDomainModule::class,
        AirTicketPresentationModule::class
    ]
)

interface AirTicketComponent {

    fun inject(fragment: AllTicketsFragment)
    fun inject(fragment: AirTicketsMainFragment)
    fun inject(fragment: ShowFlightsFragment)

}