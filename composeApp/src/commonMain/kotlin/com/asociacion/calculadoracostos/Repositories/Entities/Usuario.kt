package com.asociacion.calculadoracostos.Repositories.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Usuario(

    @PrimaryKey(autoGenerate = true)
    val id : Long?,

    var userName : String,

    var pass : String


)
