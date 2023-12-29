package com.example.gatapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gatapi.data.models.Voto
import com.example.gatapi.databinding.VistaFavoritosBinding

class VotosAdapter(

) : RecyclerView.Adapter<VotosAdapter.MiCelda>() {

    private var votos = ArrayList<Voto>()

    inner class MiCelda(val binding: VistaFavoritosBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiCelda {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = VistaFavoritosBinding.inflate(layoutInflater, parent, false)
        return MiCelda(binding)
    }

    override fun getItemCount(): Int {
       return votos.size
    }

    override fun onBindViewHolder(holder: MiCelda, position: Int) {
        val totalVotos : Voto = votos[position]

        with(holder.binding){
            Glide.with(holder
                .itemView.context)
                .load("https://cdn2.thecatapi.com/images/${totalVotos.imageId}.jpg")
                .into(holder.binding.fotoGato)
        }
    }

    fun update(lista: List<Voto>) {
        votos.clear()
        votos.addAll(lista)
        notifyDataSetChanged()
    }
}