package com.zrq.azi.ui

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.zrq.azi.adapter.ListItemAdapter
import com.zrq.azi.bean.SongOfList
import com.zrq.azi.bean.UserPlayList
import com.zrq.azi.databinding.FragmentPlayListBinding
import com.zrq.azi.interfaces.OnItemClickListener
import com.zrq.azi.interfaces.OnItemLongClickListener
import com.zrq.azi.util.Constants.BASE_URL
import com.zrq.azi.util.Constants.PLAY_LIST_ALL
import com.zrq.azi.util.Util.httpGet
import okhttp3.*
import java.io.IOException


class PlayListFragment : BaseFragment<FragmentPlayListBinding>(), OnItemClickListener, OnItemLongClickListener {
    override fun providedViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentPlayListBinding {
        return FragmentPlayListBinding.inflate(inflater, container, false)
    }

    private val list = ArrayList<SongOfList.SongsDTO>()
    private lateinit var mAdapter: ListItemAdapter
    private var playListInfo: UserPlayList.PlaylistDTO? = null
    private var offset = 0
    private var limit = 100
    private var count = 0

    @SuppressLint("NotifyDataSetChanged")
    override fun initData() {
        playListInfo = mainModel.playListInfo
        count = mainModel.playListCount

        mAdapter = ListItemAdapter(requireContext(), list, this, this)
        mBinding.apply {
            recyclerView.adapter = mAdapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }

        Log.d(TAG, "songGson: ${playListInfo!!.songGson}")
        if (playListInfo?.songGson != null && playListInfo?.songGson != "") {
            list.clear()
            val l: ArrayList<SongOfList.SongsDTO> = Gson().fromJson(mainModel.playListInfo!!.songGson, object : TypeToken<ArrayList<SongOfList.SongsDTO>>() {}.type)
            list.addAll(l)
            offset = list.size / limit
        } else {
            loadListSong()
        }
    }

    override fun initEvent() {
        mBinding.apply {
            refreshLayout.setOnRefreshListener {
                offset = 0
                loadListSong()
            }

            refreshLayout.setOnLoadMoreListener {
                offset++
                if (offset * limit > count) {
                    it.finishLoadMore()
                } else {
                    loadListSong()
                }
            }
            recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                @RequiresApi(Build.VERSION_CODES.P)
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (dy > 40) {
                        mainModel.setScreen()
                    }
                }

                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                }
            })
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun loadListSong() {
        if (playListInfo != null) {
            val url = "$BASE_URL$PLAY_LIST_ALL?id=${playListInfo!!.id}&offset=${offset * limit}&limit=$limit"
            httpGet(url) { success, msg ->
                if (success) {
                    val songOfList = Gson().fromJson(msg, SongOfList::class.java)
                    if (songOfList?.songs != null) {
                        if (offset == 0)
                            list.clear()
                        list.addAll(songOfList.songs)
                        list.forEach {
                            for (i in it.ar.indices) {
                                if (i == 0)
                                    it.singer = it.ar[i].name
                                else
                                    it.singer = it.singer + "/" + it.ar[i].name
                            }
                            it.singer
                        }
                        playListInfo!!.songGson = Gson().toJson(list).toString()
                        mainModel.listDaoImpl?.updateListSongs(playListInfo!!)
                        requireActivity().runOnUiThread {
                            mAdapter.notifyDataSetChanged()
                        }
                    }
                } else {
                    Log.d(TAG, "loadListSong: $msg")
                }
                mBinding.refreshLayout.finishRefresh()
                mBinding.refreshLayout.finishLoadMore()
            }
        }
    }

    override fun onItemClick(view: View, position: Int) {
        mainModel.showPlayBar()
        mainModel.playList.postValue(list)
        mainModel.position.postValue(position)
        mainModel.playerControl?.let {
            it.setList(list)
            it.play(position)
            mainModel.showPlayBar()
        }
    }

    override fun onItemLongClick(view: View, position: Int) {
    }

    companion object {
        const val TAG = "PlayListFragment"
    }

}
