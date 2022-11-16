package com.zrq.azi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zrq.azi.bean.Dj
import com.zrq.azi.dao.SongDaoImpl
import com.zrq.azi.interfaces.IPlayerControl

class MainModel : ViewModel() {

    val homeList = ArrayList<Dj.ProgramsBean>()

    val homeListCache = ArrayList<Dj.ProgramsBean>()

    val loveList =  ArrayList<Dj.ProgramsBean>()

    val position = MutableLiveData<Int>()

    var playerControl: IPlayerControl? = null

    var songDaoImpl: SongDaoImpl? = null

    var playOfPage = MutableLiveData<Int>()

}