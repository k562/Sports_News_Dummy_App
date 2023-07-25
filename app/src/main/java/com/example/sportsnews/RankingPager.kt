package com.example.sportsnews

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sportsnews.Fragments.AllRounder_Fragment
import com.example.sportsnews.Fragments.Batter_Fragment
import com.example.sportsnews.Fragments.Bowler_Fragment
import com.example.sportsnews.Fragments.Teams_Fragment

class RankingPager (fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {


    override fun getItemCount(): Int {
        return 4 // Number of tabs
    }

    override fun createFragment(position: Int): Fragment {

        return when (position) {
            0 -> Teams_Fragment()
            1 -> Batter_Fragment()
            2 -> Bowler_Fragment()
            3 -> AllRounder_Fragment()
            else -> throw IllegalArgumentException("Invalid tab position")
        }
    }
}