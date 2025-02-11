package com.asociacion.calculadoracostos.KoinDI

import com.asociacion.calculadoracostos.Data.Databases.AppDatabase
import com.asociacion.calculadoracostos.Databases.getDatabaseBuilder
import org.koin.dsl.module

actual fun platformModule() = module {
    single<AppDatabase> { getDatabaseBuilder(get()) }
}