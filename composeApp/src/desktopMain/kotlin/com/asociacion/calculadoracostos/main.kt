package com.asociacion.calculadoracostos

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.asociacion.calculadoracostos.KoinDI.initKoin

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Calculadora Costos",
    ) {

        initKoin {
            printLogger()
        }

        App()
    }
}