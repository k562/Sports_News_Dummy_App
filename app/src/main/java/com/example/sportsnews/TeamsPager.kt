package com.example.sportsnews

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sportsnews.Fragments.Domestic_Fragment
import com.example.sportsnews.Fragments.International_Fragment
import com.example.sportsnews.Fragments.Odi_Fragment
import com.example.sportsnews.Fragments.T20_Fragment
import com.example.sportsnews.Fragments.T20_Fragment2
import com.example.sportsnews.Fragments.Test_Fragment

class TeamsPager(fragmentManager: FragmentManager, lifecycle: Lifecycle) :  FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position){

            0 -> Test_Fragment()
            1 -> Odi_Fragment()
            2 -> T20_Fragment2()
            else -> throw IllegalArgumentException("Invalid tab position")

        }
    }
}