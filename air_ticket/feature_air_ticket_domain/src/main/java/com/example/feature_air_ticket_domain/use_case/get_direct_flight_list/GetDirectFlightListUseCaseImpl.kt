package com.example.feature_air_ticket_domain.use_case.get_direct_flight_list

import com.example.feature_air_ticket_data.repository.MainScreenRepositoryImpl
import com.example.feature_air_ticket_domain.model.DirectFlightDomain
import com.example.feature_air_ticket_domain.use_case.get_direct_flight_list.GetDirectFlightListUseCase
import com.example.feature_air_ticket_domain.utils.toDirectFlightDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

class GetDirectFlightListUseCaseImpl(
    private val mainScreenRepositoryImpl: MainScreenRepositoryImpl
): GetDirectFlightListUseCase {

    override fun execute(): Flow<DirectFlightDomain> =
        mainScreenRepositoryImpl.getDirectFlightList().toDirectFlightDomain().asFlow()
    
}