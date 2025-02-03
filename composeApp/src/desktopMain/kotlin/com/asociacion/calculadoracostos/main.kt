package com.asociacion.calculadoracostos

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Calculadora Costos",
    ) {
        App()
    }
}