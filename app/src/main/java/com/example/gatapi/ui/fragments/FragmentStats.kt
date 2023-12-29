package com.example.gatapi.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.gatapi.R
import com.example.gatapi.databinding.FragmentDetallesBinding
import com.example.gatapi.databinding.FragmentRazaBinding
import com.example.gatapi.databinding.FragmentStatsBinding
import com.example.gatapi.ui.MainActivity
import com.example.gatapi.ui.razaViewModel


class FragmentStats : Fragment() {

    private lateinit var binding: FragmentStatsBinding

    private val myViewModel: razaViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStatsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myViewModel.razaSelected.observe(viewLifecycleOwner) {
            (requireActivity() as MainActivity).supportActionBar?.title = it.name
            binding.affectionLevel.text = it.affectionLevel.toString()
            binding.childFriendly.text = it.childFriendly.toString()
            binding.dogFriendly.text = it.dogFriendly.toString()
            binding.grooming.text = it.grooming.toString()
            binding.healthIssues.text = it.healthIssues.toString()
            binding.intelligence.text = it.intelligence.toString()
            binding.lap.text = it.lap.toString()
            binding.indoor.text = it.indoor.toString()
            binding.adaptability.text = it.adaptability.toString()
        }
    }
}