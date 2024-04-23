package com.example.feature_air_ticket_presentation.fragment.di

import com.example.feature_air_ticket_presentation.fragment.ui.all_tickets.AllTicketsFragment
import com.example.feature_air_ticket_presentation.fragment.ui.main_screen.AirTicketsMainFragment
import com.example.feature_air_ticket_presentation.fragment.ui.show_flights.ShowFlightsFragment

interface ComponentProvider {

    fun inject(fragment: AllTicketsFragment)
    fun inject(fragment: AirTicketsMainFragment)
    fun inject(fragment: ShowFlightsFragment)

}