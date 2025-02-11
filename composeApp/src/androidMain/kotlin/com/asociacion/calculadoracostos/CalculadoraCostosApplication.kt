package com.asociacion.calculadoracostos

import android.app.Application
import com.asociacion.calculadoracostos.KoinDI.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent

class CalculadoraCostosApplication : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidLogger()
            androidContext(this@CalculadoraCostosApplication)
        }
    }

}