package com.example.gatapi.data

import android.content.Context
import com.example.gatapi.data.models.Voto
import com.example.gatapi.network.RetrofitHelper

class Repository(val context: Context) {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getRaza() = retrofit.dameTodasRazas()
    suspend fun ponerVoto(vot: Voto) = retrofit.votarImagen(vot)
    suspend fun getVoto(id_img: String) = retrofit.cogerVoto(id_img)

}