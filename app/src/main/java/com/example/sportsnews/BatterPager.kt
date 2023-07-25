package com.example.sportsnews

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class BatterPager  (fragmentManager: FragmentManager, lifecycle: Lifecycle) :  FragmentStateAdapter(fragmentManager, lifecycle)  {


    override fun getItemCount(): Int {

        return 3
    }

    override fun createFragment(position: Int): Fragment {

        return when (position){

            0 -> Test2_Fragment()
            1 -> Odi2_Fragment()
            2 -> T203_Fragment()
            else -> throw IllegalArgumentException("Invalid tab position")

        }
    }
}