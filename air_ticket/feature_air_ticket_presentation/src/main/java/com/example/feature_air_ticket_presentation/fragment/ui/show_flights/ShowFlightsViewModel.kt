package com.example.feature_air_ticket_presentation.fragment.ui.show_flights

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.feature_air_ticket_domain.use_case.get_direct_flight_list.GetDirectFlightListUseCase
import com.example.feature_air_ticket_presentation.fragment.ui.show_flights.model.DirectFlight
import com.example.feature_air_ticket_presentation.fragment.utils.toDirectFlight
import kotlinx.coroutines.launch
import ui.BaseViewModel
import javax.inject.Inject

class ShowFlightsViewModel @Inject constructor(
    private val getDirectFlightListUseCase: GetDirectFlightListUseCase
): BaseViewModel() {

    private val _directFlightsLiveData = MutableLiveData<List<DirectFlight>>()
    val directFlightsLiveData: LiveData<List<DirectFlight>> = _directFlightsLiveData

    private val _townNamesLiveData = MutableLiveData<Pair<String,String>>()
    val townNamesLiveData: LiveData<Pair<String,String>> = _townNamesLiveData

    fun getDirectFlightList() {
        val flights = mutableListOf<DirectFlight>()
        viewModelScope.launch {
            getDirectFlightListUseCase.execute().collect() { value ->
                flights.add(value.toDirectFlight())
            }
            _directFlightsLiveData.value = flights
        }
    }

    fun setTownNames(townNames: Pair<String,String>) {
        _townNamesLiveData.value = townNames
    }
}