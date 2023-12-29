package com.example.gatapi.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.gatapi.databinding.FragmentVotacionesBinding
import com.example.gatapi.ui.adapters.VotosAdapter
import com.example.gatapi.ui.razaViewModel


class FragmentVotaciones : Fragment() {

    private lateinit var binding: FragmentVotacionesBinding

    private val votos by activityViewModels<razaViewModel> {
        razaViewModel.MyViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVotacionesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = StaggeredGridLayoutManager(1, RecyclerView.VERTICAL)

        val votosAdapter = VotosAdapter()
        binding.recyclerView.adapter = votosAdapter


        votos.todosVotos.observe(viewLifecycleOwner) {
            if (it != null)
                votosAdapter.update(it)
        }
        votos.getVoto("usuario")
    }
}