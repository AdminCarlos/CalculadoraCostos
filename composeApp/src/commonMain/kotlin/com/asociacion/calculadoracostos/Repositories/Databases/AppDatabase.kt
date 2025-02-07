package com.asociacion.calculadoracostos.Repositories.Databases

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.asociacion.calculadoracostos.Repositories.DAOs.UsuarioDAO
import com.asociacion.calculadoracostos.Repositories.DatabasesConstructors.AppDatabaseConstructor
import com.asociacion.calculadoracostos.Repositories.Entities.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

@Database(entities = [Usuario::class], version = 1 )
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getUsuarioDAO(): UsuarioDAO

    fun getRoomDatabase(
        builder: RoomDatabase.Builder<AppDatabase>
    ): AppDatabase {
        return builder
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }

}