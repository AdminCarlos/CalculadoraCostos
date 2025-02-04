package com.asociacion.calculadoracostos

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.asociacion.calculadoracostos.ViewModels.LoginViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(loginViewModel: LoginViewModel = viewModel { LoginViewModel() }) {


    val textoState = loginViewModel.texto.collectAsState(Dispatchers.IO)

    MaterialTheme {


        Row {
            Text(text = loginViewModel.texto.value, color = Color.Blue)

            Button(onClick = {
                if (loginViewModel.texto.value.equals("Hola")) {
                    loginViewModel.setTexto("Adios")
                } else {
                    loginViewModel.setTexto("Hola")
                }

            }) {
                Text(text = "Click", color = Color.Red)
            }
        }


    }
}