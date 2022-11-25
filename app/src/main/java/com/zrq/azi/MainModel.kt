package com.zrq.azi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zrq.azi.bean.Song
import com.zrq.azi.bean.SongOfList
import com.zrq.azi.bean.UserPlayList
import com.zrq.azi.dao.ListDaoImpl
import com.zrq.azi.interfaces.IPlayerControl
import com.zrq.azi.util.Constants.TYPE_UNKNOWN

class MainModel : ViewModel() {

    val position = MutableLiveData<Int>()

    val playList = MutableLiveData<ArrayList<Song>>()

    var playerControl: IPlayerControl? = null

    var listDaoImpl: ListDaoImpl? = null

    var hidePlayBar: () -> Unit = {}

    var showPlayBar: () -> Unit = {}

    var playListInfo: UserPlayList.PlaylistDTO? = null

    var playListCount = 0

    //设置全屏
    var setScreen: () -> Unit = {}

    var initSongListType = TYPE_UNKNOWN

    var commentId = 0L

}