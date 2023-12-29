package com.example.gatapi.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.gatapi.ui.fragments.FragmentDetalles
import com.example.gatapi.ui.fragments.FragmentInfo
import com.example.gatapi.ui.fragments.FragmentStats


class FragmentAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 1) FragmentInfo() else FragmentStats()
    }
}