package com.zrq.azi.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.zrq.azi.bean.Dj
import com.zrq.azi.databinding.FragmentPlayBarBinding
import com.zrq.azi.util.Constants.PAGE_HOME
import com.zrq.azi.util.Constants.PAGE_LOVE

class PlayBarFragment(
    private val position: Int
) : BaseFragment<FragmentPlayBarBinding>() {


    override fun providedViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPlayBarBinding {
        return FragmentPlayBarBinding.inflate(inflater, container, false)
    }

    override fun initData() {
    }

    override fun initEvent() {


        mainModel.playOfPage.observe(this) {
            var list = ArrayList<Dj.ProgramsBean>()
            when (it) {
                PAGE_HOME -> {
                    list.addAll(mainModel.homeList)
                }
                PAGE_LOVE -> {
                    list.addAll(mainModel.loveList)
                }
                else -> {}
            }
            mBinding.apply {
                tvSongName.text = list[position].name
                Glide.with(this@PlayBarFragment)
                    .load(list[position].coverUrl)
                    .into(ivAlbum)
            }
        }


    }

    companion object {
        fun newInstance(position: Int) = PlayBarFragment(position)
    }

}