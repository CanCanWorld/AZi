package com.zrq.azi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zrq.azi.bean.SongOfList
import com.zrq.azi.bean.UserPlayList
import com.zrq.azi.dao.ListDaoImpl
import com.zrq.azi.interfaces.IPlayerControl

class MainModel : ViewModel() {

    val position = MutableLiveData<Int>()

    val playList = MutableLiveData<ArrayList<SongOfList.SongsDTO>>()

    var playerControl: IPlayerControl? = null

    var listDaoImpl: ListDaoImpl? = null

    var hidePlayBar: () -> Unit = {}

    var showPlayBar: () -> Unit = {}

    var playListInfo: UserPlayList.PlaylistDTO? = null

    var playListCount = 0

    var setScreen: () -> Unit = {}

}