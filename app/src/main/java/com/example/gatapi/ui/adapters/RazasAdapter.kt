package com.example.gatapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.gatapi.R
import com.example.gatapi.data.models.RazasItem
import com.example.gatapi.databinding.HolderRazasBinding

class razasAdapter(private val listener: OnItemClickListener) :
    RecyclerView.Adapter<razasAdapter.MiCelda>(), Filterable {

    private var razas = ArrayList<RazasItem>()
    private var copiaRazas = ArrayList<RazasItem>()

    interface OnItemClickListener {
        fun onItemClick(raza: RazasItem)
    }

    inner class MiCelda(val binding: HolderRazasBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiCelda {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HolderRazasBinding.inflate(layoutInflater, parent, false)
        return MiCelda(binding)
    }

    override fun onBindViewHolder(holder: MiCelda, position: Int) {
        val razaN: RazasItem = razas[position]

        holder.binding.nombreRaza.text = razaN.name
        holder.binding.nombrePais.text = razaN.origin

        holder.itemView.setOnClickListener {
            listener.onItemClick(razaN)
        }
    }

    override fun getItemCount(): Int {
        return razas.size
    }

    fun update(lista: List<RazasItem>) {
        razas.clear()
        razas.addAll(lista)
        copiaRazas.clear()
        copiaRazas.addAll(lista)
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(p0: CharSequence?): FilterResults? {
                val busqueda = p0.toString()

                if (busqueda.isEmpty()) {
                    razas = copiaRazas
                } else {
                    razas = copiaRazas.filter {

                        it?.name?.lowercase()?.contains(busqueda.lowercase()) ?: false ||
                                it.name.lowercase()
                                    .contains(busqueda.lowercase())
                    } as ArrayList<RazasItem>
                }
                val filterResult = FilterResults()
                filterResult.values = razas
                return filterResult
            }
            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                razas = p1?.values as ArrayList<RazasItem>
                notifyDataSetChanged()
            }
        }
    }
}