package com.zrq.azi.interfaces

import com.zrq.azi.bean.Song

interface IPlayerControl {

    fun registerViewControl(viewControl: IPlayerViewControl)

    fun unRegisterViewControl()

    fun resetMediaPlayer()

    fun play(position: Int)

    fun next()

    fun setList(songList: ArrayList<Song>)

    fun seekTo(progress: Int)
}