package com.asociacion.calculadoracostos.Repositories.DatabasesConstructors

import androidx.room.RoomDatabaseConstructor
import com.asociacion.calculadoracostos.Repositories.Databases.AppDatabase

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase> {

    override fun initialize(): AppDatabase

}