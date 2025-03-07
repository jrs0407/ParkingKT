package com.example.parkingkt.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.parkingkt.R
import com.example.parkingkt.Routes

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Parking del Zaidín Vergeles",
            fontWeight = FontWeight.Bold
        )


        Image(
            painter = painterResource(id = R.drawable.park),
            contentDescription = "Logo Parking",
            modifier = Modifier
                .size(200.dp)
                .padding(20.dp)
        )

        Text(
            text = "Bienvenido a la App de Parking",
            modifier = Modifier.padding(bottom = 20.dp)
        )

        Button(onClick = {
            navController.navigate(Routes.Chart.route)
        }) {
            Text("Ver Plazas")
        }
    }
}
