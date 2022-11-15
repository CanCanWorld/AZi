package com.zrq.azi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zrq.azi.bean.Dj
import com.zrq.azi.dao.SongDaoImpl
import com.zrq.azi.interfaces.IPlayerControl

class MainModel : ViewModel() {

    val playerList = MutableLiveData<ArrayList<Dj.ProgramsBean>>()

    val position = MutableLiveData<Int>()

    var playerControl: IPlayerControl? = null

    var songDaoImpl: SongDaoImpl? = null

}