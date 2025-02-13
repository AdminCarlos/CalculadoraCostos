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

        val loginState = loginViewModel.loginState.collectAsState(Dispatchers.IO)

        MaterialTheme {

            Button(onClick = {

                loginViewModel.insertUsuario(
                    Usuario(
                        null,
                        Random.nextInt(100, 500).toString(),
                        Random.nextInt(100, 500).toString()
                    )
                )

            }) {
                Text("Click")
            }

            if (loginState.value.estaCargando == true && loginState.value.exitosa == true) {
                Text("Esta cargando...................")
            } else if (loginState.value.listaUsuario.isNotEmpty() && loginState.value.exitosa == true && loginState.value.estaCargando == false) {
                LazyColumn {

                    items(
                        items = loginState.value.listaUsuario
                    ) { usuario ->

                        Row {

                            Text(usuario.userName)

                        }

                    }

                }
            }else if (loginState.value.exitosa == false && loginState.value.estaCargando == false){

                Text("Ocurrió un error comuniquese con la oficina de sistemas")

            }


        }

    }

}