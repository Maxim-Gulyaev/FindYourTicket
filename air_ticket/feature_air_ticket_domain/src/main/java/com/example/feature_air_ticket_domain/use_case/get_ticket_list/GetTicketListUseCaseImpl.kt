package com.example.feature_air_ticket_domain.use_case.get_ticket_list

import com.example.feature_air_ticket_data.repository.MainScreenRepository
import com.example.feature_air_ticket_domain.model.TicketDomain
import com.example.feature_air_ticket_domain.utils.toTicketDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import javax.inject.Inject

class GetTicketListUseCaseImpl @Inject constructor(
    private val mainScreenRepository: MainScreenRepository
): GetTicketListUseCase {
    override fun execute(): Flow<TicketDomain> =
        mainScreenRepository.getTicketList().toTicketDomain().asFlow()
}