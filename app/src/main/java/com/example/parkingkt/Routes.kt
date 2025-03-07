package com.example.parkingkt

sealed class Routes(val route: String) {
    object Home : Routes("home")
    object Parking : Routes("parking")
    object Chart : Routes("charts")

    // Ruta con argumento "plate"
    object VehicleInfo : Routes("vehicleInfo/{plate}") {
        fun createRoute(plate: String) = "vehicleInfo/$plate"
    }

}
