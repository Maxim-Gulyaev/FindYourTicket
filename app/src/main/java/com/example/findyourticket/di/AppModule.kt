package com.example.findyourticket.di

import android.app.Application
import android.content.Context
import com.example.findyourticket.app.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(
    private val appContext: Context,
    private val application: Application
) {

    @Singleton
    @Provides
    fun provideApplication(): App = (application as App)

    @Singleton
    @Provides
    fun provideContext(): Context = appContext
}