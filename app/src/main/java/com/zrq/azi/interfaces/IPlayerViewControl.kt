package com.zrq.azi.interfaces

interface IPlayerViewControl {

    fun onSeekChange(progress: Int, elapsedTime: Int)

    fun onSongPlayOver(position: Int)

    fun onVisualizeView(mode: FloatArray)
}