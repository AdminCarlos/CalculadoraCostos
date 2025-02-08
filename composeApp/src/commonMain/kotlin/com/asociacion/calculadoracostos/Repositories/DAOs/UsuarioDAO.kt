package com.asociacion.calculadoracostos.Repositories.DAOs

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.asociacion.calculadoracostos.Repositories.Entities.Usuario
import kotlinx.coroutines.flow.Flow

@Dao
interface UsuarioDAO {

    @Insert
    fun insertUsuario(usuario: Usuario)

    @Update
    fun updateUsuario(usuario: Usuario)

    @Delete
    fun deleteUsuario(usuario: Usuario)

    @Query("""
        SELECT * FROM Usuario 
    """)
    fun getAllUsuarios() : Flow<List<Usuario>>
}