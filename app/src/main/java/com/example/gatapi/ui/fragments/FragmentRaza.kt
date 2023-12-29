package com.example.gatapi.ui.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.gatapi.R
import com.example.gatapi.data.models.RazasItem
import com.example.gatapi.databinding.FragmentRazaBinding
import com.example.gatapi.ui.razaViewModel
import com.example.gatapi.ui.adapters.razasAdapter


class FragmentRaza : Fragment() {

    private val razasV by activityViewModels<razaViewModel> {
        razaViewModel.MyViewModelFactory(requireContext())
    }
    private lateinit var binding: FragmentRazaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRazaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerview.layoutManager = StaggeredGridLayoutManager(1, RecyclerView.VERTICAL)

        val listAdapter = razasAdapter(object : razasAdapter.OnItemClickListener {
            override fun onItemClick(raza: RazasItem) {
                razasV.razaSelected.value = raza
                findNavController().navigate(R.id.action_fragmentRaza_to_fragmentDetalles)
            }
        })

        binding.irVotaciones.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentRaza_to_fragmentVotaciones)
        }

        binding.recyclerview.adapter = listAdapter

        binding.swipe.setColorSchemeColors(Color.CYAN, Color.GRAY)
        binding.swipe.setOnRefreshListener {
            razasV.getRaza()
        }

        razasV.razaLiveData.observe(viewLifecycleOwner) {
            binding.swipe.isRefreshing = false
            if (it != null)
                listAdapter.update(it)
        }
        razasV.getRaza()

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                listAdapter.filter.filter(query)
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                listAdapter.filter.filter(newText)
                return true
            }
        })
    }
}