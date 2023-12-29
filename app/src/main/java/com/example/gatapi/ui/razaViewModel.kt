package com.example.gatapi.ui

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gatapi.data.models.RazasItem
import com.example.gatapi.data.Repository
import com.example.gatapi.data.models.RespuestaVoto
import com.example.gatapi.data.models.Voto
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class razaViewModel(val context: Context) : ViewModel() {

    private val repositorio = Repository(context)

    val razaLiveData = MutableLiveData<List<RazasItem>?>()
    val razaSelected = MutableLiveData<RazasItem>()
    val votoDado = MutableLiveData<RespuestaVoto?>()
    val todosVotos = MutableLiveData<List<Voto>?>()

    // función para obtener la raza
    fun getRaza() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.getRaza()
            if (response.isSuccessful) {
                val miRespuesta = response.body()
                val listaRaza = miRespuesta
                razaLiveData.postValue(listaRaza)
            }
        }
    }

    // función para mandar voto
    fun ponerVoto(voto: Voto) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.ponerVoto(voto)
            if (response.isSuccessful) {
                val miRespuestaPonerVoto = response.body()
                votoDado.postValue(miRespuestaPonerVoto)
            }
        }
    }

    // función para obtener los votos
    fun getVoto(id_img: String){
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.getVoto(id_img)
            if (response.isSuccessful) {
                val miRespuestaGetVoto = response.body()
                todosVotos.postValue(miRespuestaGetVoto)
            }
        }
    }

    class MyViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(Context::class.java).newInstance(context)
        }
    }

}