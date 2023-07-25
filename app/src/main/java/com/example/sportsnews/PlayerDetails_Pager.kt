package com.example.sportsnews

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sportsnews.Fragments.Batting_Fragment
import com.example.sportsnews.Fragments.Bowling_Fragment
import com.example.sportsnews.Fragments.Info_Fragment

class PlayerDetails_Pager  (fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {

        return 3 // Number of tabs
    }

    override fun createFragment(position: Int): Fragment {

        // Create and return the fragment for each tab
        return when (position) {
            0 -> Info_Fragment ()
            1 -> Batting_Fragment ()
            2 -> Bowling_Fragment ()
            else -> throw IllegalArgumentException("Invalid tab position")
        }
    }
}