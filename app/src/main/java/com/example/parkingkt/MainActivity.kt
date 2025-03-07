package com.example.parkingkt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.example.parkingkt.ui.screens.AppNavigator
import com.example.parkingkt.ui.theme.ParkingktTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Habilita edge-to-edge
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ParkingktTheme {
                AppNavigator()
            }
        }
    }
}