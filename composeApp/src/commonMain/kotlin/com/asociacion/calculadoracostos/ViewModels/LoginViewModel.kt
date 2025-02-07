package com.asociacion.calculadoracostos.ViewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.*

class LoginViewModel : ViewModel() {

    private val _texto = MutableStateFlow("")
    val texto: StateFlow<String> = _texto.asStateFlow()


    fun setTexto(newTexto: String) {
        _texto.update{
            newTexto
        }
    }


}