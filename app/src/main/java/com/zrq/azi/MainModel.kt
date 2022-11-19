package com.zrq.azi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zrq.azi.bean.Dj
import com.zrq.azi.bean.UserPlayList
import com.zrq.azi.dao.SongDaoImpl
import com.zrq.azi.interfaces.IPlayerControl

class MainModel : ViewModel() {

    val homeList = ArrayList<Dj.ProgramsBean>()

    val homeListCache = ArrayList<UserPlayList.PlaylistDTO>()

    val loveList = ArrayList<Dj.ProgramsBean>()

    val position = MutableLiveData<Int>()

    var playerControl: IPlayerControl? = null

    var songDaoImpl: SongDaoImpl? = null

    var playOfPage = MutableLiveData<Int>()

    var hidePlayBar: () -> Unit = {}

    var showPlayBar: () -> Unit = {}

}