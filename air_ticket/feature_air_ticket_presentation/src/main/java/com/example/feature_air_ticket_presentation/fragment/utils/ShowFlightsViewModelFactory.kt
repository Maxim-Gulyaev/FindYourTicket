package com.example.feature_air_ticket_presentation.fragment.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.feature_air_ticket_domain.use_case.get_music_offer_list.GetDirectFlightListUseCase
import com.example.feature_air_ticket_presentation.fragment.ui.show_flights.ShowFlightsViewModel

class ShowFlightsViewModelFactory(
    private val getDirectFlightListUseCase: GetDirectFlightListUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShowFlightsViewModel(getDirectFlightListUseCase) as T
    }

}