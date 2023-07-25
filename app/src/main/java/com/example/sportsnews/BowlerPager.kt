package com.example.sportsnews

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class BowlerPager  (fragmentManager: FragmentManager, lifecycle: Lifecycle) :  FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {

        return when (position){

            0 -> Test3_Fragment()
            1 -> Odi3_Fragment()
            2 -> T204_Fragment()
            else -> throw IllegalArgumentException("Invalid tab position")

        }
    }
}