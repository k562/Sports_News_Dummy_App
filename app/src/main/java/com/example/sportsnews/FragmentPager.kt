package com.example.sportsnews

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sportsnews.Fragments.NewsInfo
import com.example.sportsnews.Fragments.Info_Fragment2

class FragmentPager(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {


    override fun getItemCount(): Int {
        return 2 // Number of tabs
    }

    override fun createFragment(position: Int): Fragment {

        // Create and return the fragment for each tab
        return when (position) {
            0 -> Info_Fragment2 ()
            1 -> NewsInfo ()

            else -> throw IllegalArgumentException("Invalid tab position")
        }
    }
}