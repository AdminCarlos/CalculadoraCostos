package com.asociacion.calculadoracostos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.asociacion.calculadoracostos.Databases.getDatabaseBuilder
import com.asociacion.calculadoracostos.Repositories.Databases.AppDatabase
import com.asociacion.calculadoracostos.Repositories.Entities.Usuario

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = getDatabaseBuilder(this).build()

        db.getUsuarioDAO().insertUsuario(
            Usuario(
                null, "Paola", "Pass"
            )
        )

        setContent {
            App()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}