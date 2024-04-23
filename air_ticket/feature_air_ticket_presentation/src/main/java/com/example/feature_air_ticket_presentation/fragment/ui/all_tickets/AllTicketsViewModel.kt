package com.example.feature_air_ticket_presentation.fragment.ui.all_tickets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.feature_air_ticket_domain.use_case.get_ticket_list.GetTicketListUseCase
import com.example.feature_air_ticket_presentation.fragment.ui.all_tickets.model.Ticket
import com.example.feature_air_ticket_presentation.fragment.ui.show_flights.model.TravelData
import com.example.feature_air_ticket_presentation.fragment.utils.toTicket
import kotlinx.coroutines.launch
import ui.BaseViewModel

class AllTicketsViewModel (
    private val getTicketListUseCase: GetTicketListUseCase
): BaseViewModel() {

    private val _travelInfoLiveData = MutableLiveData<TravelData>()
    val travelInfoLiveData: LiveData<TravelData> = _travelInfoLiveData

    private val _ticketListLiveData = MutableLiveData<List<Ticket>>()
    val ticketListLiveData: LiveData<List<Ticket>> = _ticketListLiveData

    fun getTicketList() {
        val tickets = mutableListOf<Ticket>()
        viewModelScope.launch {
            getTicketListUseCase.execute().collect() { value ->
                tickets.add(value.toTicket())
            }
            _ticketListLiveData.value = tickets
        }
    }

    fun setTravelData(
        travelData: TravelData
    ) {
        viewModelScope.launch {
            _travelInfoLiveData.value = travelData
        }
    }
}