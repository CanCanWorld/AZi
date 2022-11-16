package com.zrq.azi.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.zrq.azi.bean.Dj
import com.zrq.azi.databinding.FragmentPlayBarBinding
import com.zrq.azi.util.Constants.PAGE_HOME
import com.zrq.azi.util.Constants.PAGE_LOVE

class PlayBarFragment(
    private val song: Dj.ProgramsBean
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
            mBinding.apply {
                tvSongName.text = song.name
                Glide.with(this@PlayBarFragment)
                    .load(song.coverUrl)
                    .into(ivAlbum)
            }
        }


    }

    companion object {
        fun newInstance(song: Dj.ProgramsBean) = PlayBarFragment(song)
    }

}