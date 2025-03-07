package com.example.parkingkt.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.parkingkt.Routes
import com.example.parkingkt.ui.ParkingViewModel
import androidx.compose.runtime.remember
import androidx.navigation.navArgument


@Composable
fun AppNavigator() {
    val navController = rememberNavController()
    // Ejemplo: si quieres un único ViewModel para manejar plazas,
    // puedes crearlo una sola vez aquí y pasarlo a las pantallas.
    val parkingViewModel = remember { ParkingViewModel() }

    NavHost(navController = navController, startDestination = Routes.Home.route) {
        // Pantallas nuevas:
        composable(Routes.Home.route) {
            HomeScreen(navController)
        }
        composable(Routes.Chart.route) {
            ChartScreen(navController)
        }
        composable(Routes.Parking.route) {
            ParkingScreen(navController, parkingViewModel)
        }

        // Pantalla con argumento "plate"
        composable(
            route = Routes.VehicleInfo.route,
            arguments = listOf(navArgument("plate") { type = NavType.StringType })
        ) { backStackEntry ->
            VehicleInfoScreen(
                backStackEntry = backStackEntry,
                viewModel = parkingViewModel
            )
        }
    }
}
