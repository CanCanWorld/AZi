package com.zrq.azi.interfaces

import com.zrq.azi.bean.Dj
import com.zrq.azi.bean.SongOfList

interface IPlayerControl {

    fun registerViewControl(viewControl: IPlayerViewControl)

    fun unRegisterViewControl()

    fun resetMediaPlayer()

    fun play(position: Int)

    fun next()

    fun setList(list: ArrayList<SongOfList.SongsDTO>)

    fun getList(): ArrayList<SongOfList.SongsDTO>

    fun seekTo(progress: Int)
}