package com.zrq.azi.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.zrq.azi.bean.Dj
import com.zrq.azi.bean.SongOfList
import com.zrq.azi.ui.PlayBarFragment

class ViewpagerAdapter(
    fragmentActivity: FragmentActivity,
    var list: ArrayList<SongOfList.SongsDTO>
) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return PlayBarFragment.newInstance(list[position])
    }

}