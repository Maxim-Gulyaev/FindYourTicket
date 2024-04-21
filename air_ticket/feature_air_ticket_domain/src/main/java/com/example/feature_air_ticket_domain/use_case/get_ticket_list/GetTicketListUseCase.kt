package com.example.feature_air_ticket_domain.use_case.get_ticket_list

import com.example.feature_air_ticket_domain.model.TicketDomain
import kotlinx.coroutines.flow.Flow

interface GetTicketListUseCase {
    fun execute(): Flow<TicketDomain>
}