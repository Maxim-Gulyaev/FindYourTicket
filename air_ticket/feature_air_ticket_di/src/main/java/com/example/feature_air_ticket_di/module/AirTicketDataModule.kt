package com.example.feature_air_ticket_di.module

import com.example.feature_air_ticket_data.data_source.MainScreenDataSource
import com.example.feature_air_ticket_data.data_source.MainScreenDataSourceImpl
import com.example.feature_air_ticket_data.repository.MainScreenRepository
import com.example.feature_air_ticket_data.repository.MainScreenRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class AirTicketDataModule {

    @Provides
    fun provideMainScreenDataSource(): MainScreenDataSource =
        MainScreenDataSourceImpl()

    @Provides
    fun provideMainScreenRepository(
        mainScreenDataSource: MainScreenDataSource
    ): MainScreenRepository =
        MainScreenRepositoryImpl(
            mainScreenDataSource = mainScreenDataSource
        )
}