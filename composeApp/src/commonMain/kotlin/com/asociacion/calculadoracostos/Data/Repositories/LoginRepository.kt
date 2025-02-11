package com.asociacion.calculadoracostos.Data.Repositories

import com.asociacion.calculadoracostos.Data.Databases.AppDatabase
import com.asociacion.calculadoracostos.Data.Entities.Usuario

class LoginRepository(private val appDatabase: AppDatabase) {

    fun getAllUsuarios() = appDatabase.getUsuarioDAO().getAllUsuarios()

    suspend fun insertUsuario(usuario: Usuario) = appDatabase.getUsuarioDAO().insertUsuario(usuario)

}