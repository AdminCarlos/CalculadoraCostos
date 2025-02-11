package com.asociacion.calculadoracostos.KoinDI

import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.KoinAppDeclaration
import com.asociacion.calculadoracostos.Data.Repositories.LoginRepository
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import com.asociacion.calculadoracostos.ViewModels.LoginViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

expect fun platformModule() : Module

fun initKoin(config : KoinAppDeclaration? = null) =
    startKoin {
        config?.invoke(this)
        modules(
            provideRepositoryModule,
            provideViewModelModule,
            platformModule()
        )
    }

val provideRepositoryModule = module {
    singleOf(::LoginRepository).bind(LoginRepository::class)
}

val provideViewModelModule = module {
    viewModelOf(::LoginViewModel)
}