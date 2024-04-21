package com.example.feature_air_ticket_domain.use_case.get_ticket_list

import com.example.feature_air_ticket_data.repository.MainScreenRepositoryImpl
import com.example.feature_air_ticket_domain.model.TicketDomain
import com.example.feature_air_ticket_domain.utils.toTicketDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

class GetTicketListUseCaseImpl(
    private val mainScreenRepositoryImpl: MainScreenRepositoryImpl
): GetTicketListUseCase {
    override fun execute(): Flow<TicketDomain> =
        mainScreenRepositoryImpl.getTicketList().toTicketDomain().asFlow()
}