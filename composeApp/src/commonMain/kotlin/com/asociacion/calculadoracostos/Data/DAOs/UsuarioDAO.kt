package com.asociacion.calculadoracostos.Data.DAOs

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.asociacion.calculadoracostos.Data.Entities.Usuario
import kotlinx.coroutines.flow.Flow

@Dao
interface UsuarioDAO {

    @Insert
    suspend fun insertUsuario(usuario: Usuario)

    @Update
    suspend fun updateUsuario(usuario: Usuario)

    @Delete
    suspend fun deleteUsuario(usuario: Usuario)

    @Query("""
        SELECT * FROM Usuario 
    """)
    fun getAllUsuarios() : Flow<List<Usuario>>
}