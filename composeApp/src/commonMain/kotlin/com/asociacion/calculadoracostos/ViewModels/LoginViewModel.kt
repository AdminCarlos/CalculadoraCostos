package com.asociacion.calculadoracostos.ViewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class LoginViewModel : ViewModel() {

    private val _texto = MutableStateFlow("")
    val texto: StateFlow<String> = _texto.asStateFlow()


    fun setTexto(newTexto: String) {
        _texto.value = newTexto
    }


}