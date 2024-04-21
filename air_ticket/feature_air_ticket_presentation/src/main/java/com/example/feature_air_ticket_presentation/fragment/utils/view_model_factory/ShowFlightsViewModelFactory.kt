package com.example.feature_air_ticket_presentation.fragment.utils.view_model_factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.feature_air_ticket_domain.use_case.get_direct_flight_list.GetDirectFlightListUseCase
import com.example.feature_air_ticket_presentation.fragment.ui.show_flights.ShowFlightsViewModel

class ShowFlightsViewModelFactory(
    private val getDirectFlightListUseCase: GetDirectFlightListUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShowFlightsViewModel(getDirectFlightListUseCase) as T
    }

}