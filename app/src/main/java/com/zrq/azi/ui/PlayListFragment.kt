package com.zrq.azi.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.zrq.azi.databinding.FragmentPlayListBinding

class PlayListFragment : BaseFragment<FragmentPlayListBinding>() {
    override fun providedViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentPlayListBinding {
        return FragmentPlayListBinding.inflate(inflater, container, false)
    }

    override fun initData() {
    }

    override fun initEvent() {
    }

}
