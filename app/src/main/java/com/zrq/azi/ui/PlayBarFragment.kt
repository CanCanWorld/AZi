package com.zrq.azi.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.zrq.azi.bean.SongOfList
import com.zrq.azi.databinding.FragmentPlayBarBinding

class PlayBarFragment(
    private val song: SongOfList.SongsDTO
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
        mBinding.apply {
            tvSongName.text = song.name
            Glide.with(this@PlayBarFragment)
                .load(song.al.picUrl)
                .into(ivAlbum)
        }
    }

    companion object {
        fun newInstance(song: SongOfList.SongsDTO) = PlayBarFragment(song)
    }

}