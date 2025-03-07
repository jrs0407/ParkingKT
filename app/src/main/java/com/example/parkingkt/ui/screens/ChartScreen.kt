package com.example.parkingkt.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import io.socket.client.IO
import io.socket.client.Socket
import org.json.JSONArray
import java.net.URISyntaxException

@Composable
fun ChartScreen(navController: NavController) {
    var data by remember { mutableStateOf(listOf<Int>()) }
    val maxValue = data.maxOrNull() ?: 1

    // Configuración de WebSocket con Socket.IO
    val socket: Socket? = try {
        IO.socket("http://10.0.2.2:3000") // Cambia esta IP por la de tu servidor
    } catch (e: URISyntaxException) {
        null
    }

    LaunchedEffect(Unit) {
        socket?.connect()
    }

    DisposableEffect(Unit) {
        socket?.on("updateChart") { args ->
            if (args.isNotEmpty()) {
                val jsonArray = args[0] as JSONArray
                val newData = List(jsonArray.length()) { jsonArray.getInt(it) }
                data = newData
            }
        }

        onDispose {
            socket?.disconnect()
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Gráfica en Tiempo Real", fontWeight = FontWeight.Bold)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            data.forEach { value ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .height(20.dp)
                            .width((value * 20).dp)
                            .background(Color.Blue, shape = RoundedCornerShape(4.dp))
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = value.toString())
                }
            }
        }
    }
}
