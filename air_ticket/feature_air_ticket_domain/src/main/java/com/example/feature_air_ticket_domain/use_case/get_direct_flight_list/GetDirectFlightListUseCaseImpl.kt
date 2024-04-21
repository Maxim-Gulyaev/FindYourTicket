package com.example.feature_air_ticket_domain.use_case.get_direct_flight_list

import com.example.feature_air_ticket_data.repository.MainScreenRepository
import com.example.feature_air_ticket_domain.model.DirectFlightDomain
import com.example.feature_air_ticket_domain.utils.toDirectFlightDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import javax.inject.Inject

class GetDirectFlightListUseCaseImpl @Inject constructor(
    private val mainScreenRepository: MainScreenRepository
): GetDirectFlightListUseCase {

    override fun execute(): Flow<DirectFlightDomain> =
        mainScreenRepository.getDirectFlightList().toDirectFlightDomain().asFlow()
    
}