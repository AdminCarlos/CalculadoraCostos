package com.asociacion.calculadoracostos.Databases

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.asociacion.calculadoracostos.Repositories.Databases.AppDatabase


fun getDatabaseBuilder(ctx: Context): RoomDatabase.Builder<AppDatabase> {
    val appContext = ctx.applicationContext
    val dbFile = appContext.getDatabasePath("calculadora.db")
    return Room.databaseBuilder<AppDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}