package com.example.findyourticket.app

import android.app.Application
import com.example.findyourticket.di.AppComponent
import com.example.findyourticket.di.DaggerAppComponent

class App: Application() {

    val appComponent: AppComponent = DaggerAppComponent.create()
}