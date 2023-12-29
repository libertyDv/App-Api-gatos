package com.example.gatapi.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.gatapi.R
import com.example.gatapi.data.models.Voto
import com.example.gatapi.databinding.FragmentInfoBinding
import com.example.gatapi.ui.MainActivity
import com.example.gatapi.ui.razaViewModel


class FragmentInfo : Fragment() {

    private lateinit var binding: FragmentInfoBinding
    private val myViewModel: razaViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myViewModel.razaSelected.observe(viewLifecycleOwner) {
            (requireActivity() as MainActivity).supportActionBar?.title = it.name
            binding.descripciN.text = it.description

            binding.anios.text = it.lifeSpan
            binding.origen.text = it.origin
            binding.peso.text = it.weight.toString()
            binding.temperamento.text = it.temperament
        }
    }
}