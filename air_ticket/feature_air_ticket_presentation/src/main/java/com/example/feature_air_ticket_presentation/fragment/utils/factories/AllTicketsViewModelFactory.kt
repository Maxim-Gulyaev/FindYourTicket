package com.example.feature_air_ticket_presentation.fragment.utils.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.feature_air_ticket_domain.use_case.get_ticket_list.GetTicketListUseCase
import com.example.feature_air_ticket_presentation.fragment.ui.all_tickets.AllTicketsViewModel

class AllTicketsViewModelFactory(
    private val getTicketListUseCase: GetTicketListUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AllTicketsViewModel(getTicketListUseCase) as T
    }

}