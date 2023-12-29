package com.example.gatapi.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.gatapi.R
import com.example.gatapi.data.models.Voto
import com.example.gatapi.databinding.FragmentDetallesBinding
import com.example.gatapi.ui.MainActivity
import com.example.gatapi.ui.adapters.FragmentAdapter
import com.example.gatapi.ui.razaViewModel
import com.google.android.material.tabs.TabLayoutMediator

class FragmentDetalles : Fragment() {

    private lateinit var binding: FragmentDetallesBinding
    private val myViewModel: razaViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetallesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = FragmentAdapter(requireActivity())
        binding.viewpager.adapter = adapter

        TabLayoutMediator(binding.tablayout, binding.viewpager) { tab, position ->
            tab.text = if (position == 1) "Información" else "Stats"
        }.attach()

        myViewModel.razaSelected.observe(viewLifecycleOwner) {
            (requireActivity() as MainActivity).supportActionBar?.title = it.name

            Glide.with(this)
                .load("https://cdn2.thecatapi.com/images/${it.referenceImageId}.jpg")
                .into(binding.imageView)

            binding.meGusta.setOnClickListener { ivot ->
                val voto = it.referenceImageId?.let { ivot ->
                    Voto(
                        ivot,
                        "usuario",
                        1
                    )
                }
                if (voto != null) {
                    myViewModel.ponerVoto(voto)
                }
            }

        }
    }
}