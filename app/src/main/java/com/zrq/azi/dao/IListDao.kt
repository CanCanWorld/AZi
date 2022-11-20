package com.zrq.azi.dao

import com.zrq.azi.bean.UserPlayList

interface IListDao {
    fun listAllList(): ArrayList<UserPlayList.PlaylistDTO>

    fun updateAllList(newLists: ArrayList<UserPlayList.PlaylistDTO>)

    fun updateListSongs(newList: UserPlayList.PlaylistDTO)
}