package com.zrq.azi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zrq.azi.bean.Dj
import com.zrq.azi.interfaces.IPlayerControl

class MainModel : ViewModel() {

    val list = MutableLiveData<ArrayList<Dj.ProgramsBean>>()

    val position = MutableLiveData<Int>()

    var playerControl: IPlayerControl? = null

}