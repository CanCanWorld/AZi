package com.zrq.azi.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.zrq.azi.R
import com.zrq.azi.bean.Song
import com.zrq.azi.bean.SongOfList
import com.zrq.azi.databinding.FragmentPlayBarBinding
import com.zrq.azi.util.Constants.TYPE_BAR

class PlayBarFragment(
    private val song: Song
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
                .load(song.coverUrl)
                .into(ivAlbum)

            root.setOnClickListener {
                mainModel.position.value?.let { it1 -> mainModel.showBottomSheetDialog(it1, TYPE_BAR) }
            }
        }
    }

    companion object {
        fun newInstance(song: Song) = PlayBarFragment(song)
    }

}