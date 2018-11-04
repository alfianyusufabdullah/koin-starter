package com.alfianyusufabdullah.koinstarter

import android.app.Application
import com.alfianyusufabdullah.koinstarter.module.calculatorModule
import org.koin.android.ext.android.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(calculatorModule))
    }

}