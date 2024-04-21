package com.example.feature_air_ticket_presentation.fragment.ui.all_tickets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.feature_air_ticket_domain.use_case.get_ticket_list.GetTicketListUseCase
import com.example.feature_air_ticket_presentation.fragment.ui.all_tickets.model.Ticket
import com.example.feature_air_ticket_presentation.fragment.utils.toTicket
import kotlinx.coroutines.launch
import ui.BaseViewModel

class AllTicketsViewModel(
    private val getTicketListUseCase: GetTicketListUseCase
): BaseViewModel() {

    private val _ticketList = MutableLiveData<List<Ticket>>()
    val ticketList: LiveData<List<Ticket>> = _ticketList

    fun getTicketList() {
        val tickets = mutableListOf<Ticket>()
        viewModelScope.launch {
            getTicketListUseCase.execute().collect() { value ->
                tickets.add(value.toTicket())
            }
            _ticketList.value = tickets
        }
    }
}