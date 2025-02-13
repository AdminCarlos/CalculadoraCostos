package com.asociacion.calculadoracostos.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asociacion.calculadoracostos.Data.Entities.Usuario
import com.asociacion.calculadoracostos.Data.Repositories.LoginRepository
import com.asociacion.calculadoracostos.UIStates.LoginState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LoginViewModel : ViewModel(), KoinComponent {

    private val repo : LoginRepository by inject()
    private val _loginState = MutableStateFlow<LoginState>(LoginState())
    val loginState: StateFlow<LoginState> = _loginState.asStateFlow()

    init {

        viewModelScope.launch(Dispatchers.IO) {

            _loginState.value = LoginState(estaCargando = true, exitosa = true)

            delay(5000)

            repo.getAllUsuarios().collect { usuarios->

                _loginState.value = LoginState(

                    listaUsuario = usuarios,
                    estaCargando = false,
                    exitosa = false
                )

            }

        }

    }

    fun insertUsuario(usuario: Usuario) = viewModelScope.launch(Dispatchers.IO) {
        repo.insertUsuario(usuario)
    }

}