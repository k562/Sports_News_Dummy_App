package com.example.sportsnews

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sportsnews.Fragments.Domestic_Fragment
import com.example.sportsnews.Fragments.International_Fragment
import com.example.sportsnews.Fragments.T20_Fragment

class Internationalpager_Adaper(fragmentManager: FragmentManager, lifecycle: Lifecycle) :  FragmentStateAdapter(fragmentManager, lifecycle) {


    override fun getItemCount(): Int  = 3

    override fun createFragment(position: Int): Fragment {

        return when (position){

            0 -> International_Fragment()
            1 -> T20_Fragment()
            2 -> Domestic_Fragment()
            else -> throw IllegalArgumentException("Invalid tab position")

    }
      }

    }


