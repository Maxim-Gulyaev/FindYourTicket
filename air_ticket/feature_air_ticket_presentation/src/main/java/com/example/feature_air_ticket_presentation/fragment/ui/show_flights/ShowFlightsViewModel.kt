package com.example.feature_air_ticket_presentation.fragment.ui.show_flights

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.feature_air_ticket_domain.use_case.get_direct_flight_list.GetDirectFlightListUseCase
import com.example.feature_air_ticket_presentation.fragment.ui.show_flights.model.DirectFlight
import com.example.feature_air_ticket_presentation.fragment.utils.toDirectFlight
import kotlinx.coroutines.launch
import ui.BaseViewModel

class ShowFlightsViewModel(
    private val getDirectFlightListUseCase: GetDirectFlightListUseCase
): BaseViewModel() {

    private val _directFlightList = MutableLiveData<List<DirectFlight>>()
    val directFlightList: LiveData<List<DirectFlight>> = _directFlightList

    fun getDirectFlightList() {
        val flights = mutableListOf<DirectFlight>()
        viewModelScope.launch {
            getDirectFlightListUseCase.execute().collect() { value ->
                flights.add(value.toDirectFlight())
            }
            _directFlightList.value = flights
        }
    }
}