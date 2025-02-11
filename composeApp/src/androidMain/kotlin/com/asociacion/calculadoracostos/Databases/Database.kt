package com.asociacion.calculadoracostos.Databases

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.asociacion.calculadoracostos.Data.Databases.AppDatabase
import kotlinx.coroutines.Dispatchers


fun getDatabaseBuilder(ctx: Context): AppDatabase {
    val appContext = ctx.applicationContext
    val dbFile = appContext.getDatabasePath("calculadora.db")
    return Room.databaseBuilder<AppDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    ).setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}