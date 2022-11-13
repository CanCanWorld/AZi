package com.zrq.azi.interfaces

import com.zrq.azi.bean.Dj

interface IPlayerControl {

    fun registerViewControl(viewControl: IPlayerViewControl)

    fun unRegisterViewControl()

    fun resetMediaPlayer()

    fun play(position: Int)

    fun setList(list: ArrayList<Dj.ProgramsBean>)

    fun getList(): ArrayList<Dj.ProgramsBean>
}