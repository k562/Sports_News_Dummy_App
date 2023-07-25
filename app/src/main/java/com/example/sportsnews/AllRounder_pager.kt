package com.example.sportsnews

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class AllRounder_pager  (fragmentManager: FragmentManager, lifecycle: Lifecycle) :  FragmentStateAdapter(fragmentManager, lifecycle) {


    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {

        return when (position) {

            0 -> Test4_Fragment()
            1 -> Odi4_Fragment()
            2 -> T205_Fragment()
            else -> throw IllegalArgumentException("Invalid tab position")
        }
    }

}