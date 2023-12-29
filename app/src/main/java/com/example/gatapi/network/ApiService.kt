package com.example.gatapi.network

import com.example.gatapi.data.models.RazasItem
import com.example.gatapi.data.models.RespuestaVoto
import com.example.gatapi.data.models.Voto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    // para listado de razas
    @Headers("x-api-key: live_myH7k4eReRa1e10w1YUtOAAuf9fdpLyV6pkctzfvBeqXBnB72FXnf8MW2o2qVA72")
    @GET("breeds")
    suspend fun dameTodasRazas(): Response<List<RazasItem>>

    // para dar votos
    @Headers("x-api-key: live_myH7k4eReRa1e10w1YUtOAAuf9fdpLyV6pkctzfvBeqXBnB72FXnf8MW2o2qVA72",
        "Content-Type: application/json ")
    @POST("votes")
    suspend fun votarImagen(
        @Body voto: Voto
    ): Response<RespuestaVoto>

    // para tomar votos
    @Headers("x-api-key: live_myH7k4eReRa1e10w1YUtOAAuf9fdpLyV6pkctzfvBeqXBnB72FXnf8MW2o2qVA72",
        "Content-Type: application/json ")
    @GET("votes")
    suspend fun cogerVoto(
        @Query("sub_id") id_img : String
    ): Response<List<Voto>>
}