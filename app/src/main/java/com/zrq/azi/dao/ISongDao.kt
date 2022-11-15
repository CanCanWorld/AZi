package com.zrq.azi.dao

import com.zrq.azi.bean.Dj

interface ISongDao {
    fun addSong(song: Dj.ProgramsBean): Long

    fun deleteSong(id: Int): Int

    fun listAllSongs(): ArrayList<Dj.ProgramsBean>
}