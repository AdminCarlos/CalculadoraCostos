package com.asociacion.calculadoracostos

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform