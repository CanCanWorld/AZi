package com.zrq.azi.ui

import android.annotation.SuppressLint
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.zrq.azi.R
import com.zrq.azi.adapter.DailySongsAdapter
import com.zrq.azi.adapter.ListItemAdapter
import com.zrq.azi.bean.DailySongs
import com.zrq.azi.bean.Song
import com.zrq.azi.bean.SongOfList
import com.zrq.azi.bean.UserPlayList
import com.zrq.azi.databinding.DialogBottomBinding
import com.zrq.azi.databinding.FragmentPlayListBinding
import com.zrq.azi.interfaces.OnItemClickListener
import com.zrq.azi.util.Constants.BASE_URL
import com.zrq.azi.util.Constants.COMMENT
import com.zrq.azi.util.Constants.DAILY_SONGS
import com.zrq.azi.util.Constants.LIKE
import com.zrq.azi.util.Constants.PLAY_LIST_ALL
import com.zrq.azi.util.Constants.TYPE_DAILY_SONGS
import com.zrq.azi.util.Constants.TYPE_UNKNOWN
import com.zrq.azi.util.Constants.TYPE_USER_PLAY_LIST
import com.zrq.azi.util.Util.httpGet


class PlayListFragment : BaseFragment<FragmentPlayListBinding>(), OnItemClickListener {
    override fun providedViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentPlayListBinding {
        return FragmentPlayListBinding.inflate(inflater, container, false)
    }

    private val myList = ArrayList<SongOfList.SongsDTO>()
    private val dailyList = ArrayList<DailySongs.DataDTO.DailySongsDTO>()
    private lateinit var myAdapter: ListItemAdapter
    private lateinit var dailyAdapter: DailySongsAdapter
    private var playListInfo: UserPlayList.PlaylistDTO? = null
    private var offset = 0
    private var limit = 100
    private var count = 0
    private val onMoreClick: (Int) -> Unit = { position ->
        var song: Song? = null
        bindingBottomDialog.apply {
            when (mainModel.initSongListType) {
                TYPE_USER_PLAY_LIST -> {
                    song = Song(myList[position].id, myList[position].name, myList[position].singer, myList[position].al.picUrl)
                }
                TYPE_DAILY_SONGS -> {
                    song = Song(dailyList[position].id, dailyList[position].name, dailyList[position].singer, dailyList[position].al.picUrl)
                }
                else -> {}
            }
            song?.let {
                tvSongName.text = it.name
                tvSinger.text = it.singer
                Glide.with(requireContext())
                    .load(it.coverUrl)
                    .into(ivCover)
                Glide.with(requireContext())
                    .load(it.coverUrl)
                    .into(ivBackground)
                btnDownload.setOnClickListener {
                    bottomDialog.cancel()
                }
                btnLove.setOnClickListener { _ ->
                    val url = "$BASE_URL$LIKE?id=${it.id}"
                    httpGet(url) { _, msg ->
                        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
                    }
                    bottomDialog.cancel()
                }
                btnComment.setOnClickListener { _ ->
                    mainModel.commentId = it.id
                    Navigation.findNavController(requireActivity(), R.id.fragment_container)
                        .navigate(R.id.commentFragment)
                    bottomDialog.cancel()
                }
            }
        }
        bottomDialog.show()
    }
    private val bottomDialog: BottomSheetDialog by lazy {
        BottomSheetDialog(requireContext()).apply {
            setContentView(bindingBottomDialog.root)
        }
    }

    private val bindingBottomDialog by lazy {
        DialogBottomBinding.inflate(LayoutInflater.from(requireContext()))
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun initData() {
        when (mainModel.initSongListType) {
            TYPE_UNKNOWN -> {
                Toast.makeText(requireContext(), "未知跳转", Toast.LENGTH_SHORT).show()
            }
            TYPE_USER_PLAY_LIST -> {
                playListInfo = mainModel.playListInfo
                count = mainModel.playListCount

                myAdapter = ListItemAdapter(requireContext(), myList, this, onMoreClick)
                mBinding.apply {
                    recyclerView.adapter = myAdapter
                    recyclerView.layoutManager = LinearLayoutManager(requireContext())
                }

                if (playListInfo?.songGson != null && playListInfo?.songGson != "") {
                    myList.clear()
                    val l: ArrayList<SongOfList.SongsDTO> = Gson().fromJson(mainModel.playListInfo!!.songGson, object : TypeToken<ArrayList<SongOfList.SongsDTO>>() {}.type)
                    myList.addAll(l)
                    offset = myList.size / limit
                } else {
                    loadMyList()
                }
            }
            TYPE_DAILY_SONGS -> {
                dailyAdapter = DailySongsAdapter(requireContext(), dailyList, this, onMoreClick)
                mBinding.apply {
                    recyclerView.adapter = dailyAdapter
                    recyclerView.layoutManager = LinearLayoutManager(requireContext())
                }
                loadDailyList()
            }
            else -> {}
        }
    }

    override fun initEvent() {
        when (mainModel.initSongListType) {
            TYPE_USER_PLAY_LIST -> {
                mBinding.apply {
                    refreshLayout.setOnRefreshListener {
                        offset = 0
                        loadMyList()
                    }

                    refreshLayout.setOnLoadMoreListener {
                        offset++
                        if (offset * limit > count) {
                            it.finishLoadMore()
                        } else {
                            loadMyList()
                        }
                    }
                }
            }
            TYPE_DAILY_SONGS -> {
                mBinding.apply {
                    refreshLayout.setOnRefreshListener {
                        offset = 0
                        loadDailyList()
                    }

                    refreshLayout.setOnLoadMoreListener {
                        mBinding.refreshLayout.finishLoadMore()
                    }
                }
            }
            else -> {}
        }
        mBinding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            @RequiresApi(Build.VERSION_CODES.P)
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 20) {
                    mainModel.setScreen()
                }
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            }
        })
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun loadMyList() {
        if (playListInfo != null) {
            val url = "$BASE_URL$PLAY_LIST_ALL?id=${playListInfo!!.id}&offset=${offset * limit}&limit=$limit"
            httpGet(url) { success, msg ->
                if (success) {
                    val songOfList = Gson().fromJson(msg, SongOfList::class.java)
                    if (songOfList?.songs != null) {
                        if (offset == 0)
                            myList.clear()
                        myList.addAll(songOfList.songs)
                        myList.forEach {
                            for (i in it.ar.indices) {
                                if (i == 0)
                                    it.singer = it.ar[i].name
                                else
                                    it.singer = it.singer + "/" + it.ar[i].name
                            }
                        }
                        playListInfo!!.songGson = Gson().toJson(myList).toString()
                        mainModel.listDaoImpl?.updateListSongs(playListInfo!!)
                        Handler(Looper.getMainLooper()).post {
                            myAdapter.notifyDataSetChanged()
                        }
                    }
                } else {
                    Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
                }
                mBinding.refreshLayout.finishRefresh()
                mBinding.refreshLayout.finishLoadMore()
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun loadDailyList() {
        val url = "$BASE_URL$DAILY_SONGS"
        httpGet(url) { success, msg ->
            if (success) {
                val dailySongs = Gson().fromJson(msg, DailySongs::class.java)
                if (dailySongs?.data?.dailySongs != null) {
                    dailyList.clear()
                    dailyList.addAll(dailySongs.data.dailySongs)
                    dailyList.forEach {
                        for (i in it.ar.indices) {
                            if (i == 0)
                                it.singer = it.ar[i].name
                            else
                                it.singer = it.singer + "/" + it.ar[i].name
                        }
                    }
                    Handler(Looper.getMainLooper()).post {
                        dailyAdapter.notifyDataSetChanged()
                    }
                }
            } else {
                Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
            }
            mBinding.refreshLayout.finishRefresh()
            mBinding.refreshLayout.finishLoadMore()
        }
    }

    override fun onItemClick(view: View, position: Int) {
        mainModel.showPlayBar()

        val songs = ArrayList<Song>()
        when (mainModel.initSongListType) {
            TYPE_USER_PLAY_LIST -> {
                myList.forEach {
                    songs.add(Song(it.id, it.name, it.singer, it.al.picUrl))
                }
            }
            TYPE_DAILY_SONGS -> {
                dailyList.forEach {
                    songs.add(Song(it.id, it.name, it.singer, it.al.picUrl))
                }
            }
            else -> {}
        }
        mainModel.playList.postValue(songs)
        mainModel.position.postValue(position)
        mainModel.playerControl?.let {
            it.setList(songs)
            it.play(position)
            mainModel.showPlayBar()
        }
    }

    companion object {
        const val TAG = "PlayListFragment"
    }

}
