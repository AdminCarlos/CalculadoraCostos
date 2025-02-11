package com.asociacion.calculadoracostos.Data.Databases

import androidx.room.Database
import androidx.room.RoomDatabase
import com.asociacion.calculadoracostos.Data.DAOs.UsuarioDAO
import com.asociacion.calculadoracostos.Data.Entities.Usuario

@Database(entities = [Usuario::class], version = 1 )
abstract class AppDatabase : RoomDatabase(), DB {

    abstract fun getUsuarioDAO(): UsuarioDAO
    override fun clearAllTables() {}
}

interface DB {
    fun clearAllTables() {}
}