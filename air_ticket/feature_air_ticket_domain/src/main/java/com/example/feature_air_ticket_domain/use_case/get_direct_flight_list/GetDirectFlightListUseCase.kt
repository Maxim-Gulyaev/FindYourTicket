package com.example.feature_air_ticket_domain.use_case.get_direct_flight_list

import com.example.feature_air_ticket_domain.model.DirectFlightDomain
import kotlinx.coroutines.flow.Flow

interface GetDirectFlightListUseCase {
    fun execute(): Flow<DirectFlightDomain>
}