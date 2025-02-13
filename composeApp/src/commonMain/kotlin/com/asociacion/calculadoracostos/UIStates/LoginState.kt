package com.asociacion.calculadoracostos.UIStates

import com.asociacion.calculadoracostos.Data.Entities.Usuario

data class LoginState(

    var estaCargando : Boolean? = null,
    var exitosa : Boolean?= null,
    var listaUsuario : List<Usuario> = emptyList()






)
