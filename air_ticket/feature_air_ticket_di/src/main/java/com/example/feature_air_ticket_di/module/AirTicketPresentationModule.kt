package com.example.feature_air_ticket_di.module

import androidx.lifecycle.ViewModelProvider
import com.example.feature_air_ticket_presentation.fragment.ui.all_tickets.AllTicketsFragment
import com.example.feature_air_ticket_presentation.fragment.ui.all_tickets.AllTicketsViewModel
import com.example.feature_air_ticket_presentation.fragment.ui.main_screen.AirTicketsMainFragment
import com.example.feature_air_ticket_presentation.fragment.ui.main_screen.AirTicketsMainViewModel
import com.example.feature_air_ticket_presentation.fragment.ui.show_flights.ShowFlightsFragment
import com.example.feature_air_ticket_presentation.fragment.ui.show_flights.ShowFlightsViewModel
import dagger.Module
import dagger.Provides
import ui.BaseFragment
import ui.BaseViewModel

@Module
class AirTicketPresentationModule {

    @Provides
    fun provideBaseViewModel(): BaseViewModel {
        return BaseViewModel()
    }

    @Provides
    fun provideBaseFragment(): BaseFragment {
        return BaseFragment()
    }

    @Provides
    fun provideAllTicketsViewModel(fragment: AllTicketsFragment): AllTicketsViewModel {
        return ViewModelProvider(fragment).get(AllTicketsViewModel::class.java)
    }

    @Provides
    fun provideAirTicketsMainViewModel(fragment: AirTicketsMainFragment): AirTicketsMainViewModel {
        return ViewModelProvider(fragment).get(AirTicketsMainViewModel::class.java)
    }

    @Provides
    fun provideShowFlightsViewModel(fragment: ShowFlightsFragment): ShowFlightsViewModel {
        return ViewModelProvider(fragment).get(ShowFlightsViewModel::class.java)
    }

}