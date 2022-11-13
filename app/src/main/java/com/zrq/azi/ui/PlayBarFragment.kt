package com.zrq.azi.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.zrq.azi.databinding.FragmentPlayBarBinding

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
        mainModel.list.observe(this) {
            mBinding.apply {
                tvSongName.text = it[position].name
                Glide.with(this@PlayBarFragment)
                    .load(it[position].coverUrl)
                    .into(ivAlbum)
            }

        }

    }

    companion object {
        fun newInstance(position: Int) = PlayBarFragment(position)
    }

}