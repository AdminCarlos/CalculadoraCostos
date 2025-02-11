package com.asociacion.calculadoracostos.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asociacion.calculadoracostos.Data.Entities.Usuario
import com.asociacion.calculadoracostos.Data.Repositories.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LoginViewModel : ViewModel(), KoinComponent {

    private val repo : LoginRepository by inject()
    private val _usuario = MutableStateFlow<List<Usuario>>(emptyList())
    val usuario: StateFlow<List<Usuario>> = _usuario.asStateFlow()

    init {

        viewModelScope.launch(Dispatchers.IO) {

            repo.getAllUsuarios().collect {

                _usuario.value = it

            }

        }

    }

    fun insertUsuario(usuario: Usuario) = viewModelScope.launch(Dispatchers.IO) {
        repo.insertUsuario(usuario)
    }

}