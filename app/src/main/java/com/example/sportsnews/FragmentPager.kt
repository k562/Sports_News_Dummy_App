package com.example.sportsnews

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sportsnews.Fragments.Live
import com.example.sportsnews.Fragments.FragmentTab2
import com.example.sportsnews.Fragments.FragmentTab3

class FragmentPager(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {


    override fun getItemCount(): Int {
        return 3 // Number of tabs
    }

    override fun createFragment(position: Int): Fragment {

        // Create and return the fragment for each tab
        return when (position) {
            0 -> Live()
            1 -> FragmentTab2()
            2 -> FragmentTab3()
            else -> throw IllegalArgumentException("Invalid tab position")
        }
    }
}