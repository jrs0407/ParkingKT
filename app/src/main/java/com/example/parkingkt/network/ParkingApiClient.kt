package com.example.parkingkt.network

import com.example.parkingkt.model.Spot
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// Interfaz con sus endpoints:
interface ParkingApiService {
    // GET a la ruta /spots
    @GET("spots")
    suspend fun getSpots(): List<Spot>
}

//Crear el objeto que construye Retrofit y las funciones:
object ParkingApiClient {
    private const val BASE_URL = "http://10.0.2.2:6000/api/"

    // Instancia de Retrofit con convertidor Gson
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Instancia del servicio
    private val apiService: ParkingApiService = retrofit.create(ParkingApiService::class.java)

    // Función para obtener la lista de spots usando Retrofit
    suspend fun getSpots(): List<Spot> {
        return apiService.getSpots()
    }
}
