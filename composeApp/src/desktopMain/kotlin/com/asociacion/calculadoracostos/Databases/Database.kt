package com.asociacion.calculadoracostos.Databases

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.asociacion.calculadoracostos.Data.Databases.AppDatabase
import kotlinx.coroutines.Dispatchers
import java.io.File

fun getDatabaseBuilder(): AppDatabase {
    val dbFile = File(System.getProperty("java.io.tmpdir"), "calculadora.db")

    return Room.databaseBuilder<AppDatabase>(dbFile.absolutePath)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}