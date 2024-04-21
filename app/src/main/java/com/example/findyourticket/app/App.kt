package com.example.findyourticket.app

import android.app.Application
import com.example.feature_air_ticket_di.component.AirTicketComponent
import com.example.feature_air_ticket_di.component.DaggerAirTicketComponent
import com.example.findyourticket.di.AppComponent
import com.example.findyourticket.di.DaggerAppComponent

class App: Application() {

    private lateinit var appComponent: AppComponent
    private lateinit var airTicketComponent: AirTicketComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.create()
        airTicketComponent = DaggerAirTicketComponent.create()

    }


}