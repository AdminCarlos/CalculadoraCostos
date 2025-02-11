package com.asociacion.calculadoracostos

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.asociacion.calculadoracostos.Data.Entities.Usuario
import com.asociacion.calculadoracostos.ViewModels.LoginViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel
import kotlin.random.Random

@Composable
@Preview
fun App() {

    KoinContext {

        val loginViewModel = koinViewModel<LoginViewModel>()

        val usuarios = loginViewModel.usuario.collectAsState(Dispatchers.IO).value

        MaterialTheme {

            Button(onClick = {

                loginViewModel.insertUsuario(Usuario(null, Random.nextInt(100, 500).toString(), Random.nextInt(100, 500).toString()))

            }) {
                Text("Click")
            }

            LazyColumn {

                items(
                    items = usuarios,
                    key = { usuario ->
                        usuario.id!!
                    }
                ) { usuario ->

                    Row {

                        Text(usuario.userName)

                    }

                }

            }

        }

    }

}