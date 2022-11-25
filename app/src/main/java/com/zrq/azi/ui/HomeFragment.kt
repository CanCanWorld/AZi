package com.zrq.azi.ui

import android.annotation.SuppressLint
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.tencent.mmkv.MMKV
import com.zrq.azi.R
import com.zrq.azi.adapter.PlayListAdapter
import com.zrq.azi.bean.UserPlayList
import com.zrq.azi.databinding.FragmentHomeBinding
import com.zrq.azi.interfaces.OnItemClickListener
import com.zrq.azi.interfaces.OnItemLongClickListener
import com.zrq.azi.util.Constants.BASE_URL
import com.zrq.azi.util.Constants.LOGOUT
import com.zrq.azi.util.Constants.MMKV_AVATAR_URL
import com.zrq.azi.util.Constants.MMKV_NICKNAME
import com.zrq.azi.util.Constants.MMKV_UID
import com.zrq.azi.util.Constants.TYPE_DAILY_SONGS
import com.zrq.azi.util.Constants.TYPE_USER_PLAY_LIST
import com.zrq.azi.util.Constants.USER_PLAY_LIST
import com.zrq.azi.util.ToastUtil
import com.zrq.azi.util.Util.httpGet
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class HomeFragment : BaseFragment<FragmentHomeBinding>(), OnItemClickListener, OnItemLongClickListener {
    override fun providedViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    private val list = ArrayList<UserPlayList.PlaylistDTO>()
    private lateinit var mAdapter: PlayListAdapter
    private var offset = 1

    @SuppressLint("NotifyDataSetChanged", "SimpleDateFormat")
    @RequiresApi(Build.VERSION_CODES.P)
    override fun initData() {
        mAdapter = PlayListAdapter(requireContext(), list, this, this)
        mBinding.apply {
            recyclerView.adapter = mAdapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())

            SimpleDateFormat("dd").apply { tvToday.text = format(Date()) }
        }
        if (mainModel.listDaoImpl != null) {
            if (mainModel.listDaoImpl!!.listAllList().size != 0) {
                list.clear()
                list.addAll(mainModel.listDaoImpl!!.listAllList())
                mAdapter.notifyDataSetChanged()
            } else {
                loadUserPlayList()
            }
        }

        val avatarUrl = MMKV.defaultMMKV().decodeString(MMKV_AVATAR_URL, "")
        val nickname = MMKV.defaultMMKV().decodeString(MMKV_NICKNAME, "游客登录")
        mBinding.tvUsername.text = nickname
        Glide.with(requireActivity()).load(avatarUrl).into(mBinding.ivUserHead)

        val uid = MMKV.defaultMMKV().decodeString(MMKV_UID, "")
        if (uid == "") {
            Navigation.findNavController(requireActivity(), R.id.fragment_container)
                .navigate(R.id.loginFragment)
        }
    }

    override fun initEvent() {
        mBinding.apply {

            refreshLayout.setOnRefreshListener {
                offset = 1
                loadUserPlayList()
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

            btnExit.setOnClickListener {
                exit()
            }

            btnDailySongs.setOnClickListener {
                mainModel.initSongListType = TYPE_DAILY_SONGS
                Navigation.findNavController(requireActivity(), R.id.fragment_container)
                    .navigate(R.id.action_homeFragment_to_playListFragment)
            }
        }
    }

    private fun exit() {
        MMKV.defaultMMKV().putString(MMKV_UID, "")
        MMKV.defaultMMKV().putString(MMKV_AVATAR_URL, "")
        MMKV.defaultMMKV().putString(MMKV_NICKNAME, "")
        mainModel.listDaoImpl?.removeAll()

        val url = "$BASE_URL$LOGOUT"
        httpGet(url) { _, msg ->
            ToastUtil.showToast(requireContext(), msg)
        }
        Navigation.findNavController(requireActivity(), R.id.fragment_container)
            .navigate(R.id.loginFragment)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun loadUserPlayList() {
        //1443709708
        val uid = MMKV.defaultMMKV().decodeString(MMKV_UID, "")
        val url = "$BASE_URL$USER_PLAY_LIST?uid=$uid&offset=0&limit=200"
        httpGet(url) { success, msg ->
            if (success) {
                val playList = Gson().fromJson(msg, UserPlayList::class.java)
                if (playList?.playlist != null) {
                    //存入数据库
                    mainModel.listDaoImpl?.updateAllList(playList.playlist)
                    mainModel.listDaoImpl?.let { it1 ->
                        list.clear()
                        list.addAll(it1.listAllList())
                    }
                    Handler(Looper.getMainLooper()).post {
                        mAdapter.notifyDataSetChanged()
                    }
                }
            } else {
                Log.d(TAG, "loadUserPlayList: $msg")
            }
            mBinding.refreshLayout.finishRefresh()
        }
    }

    override fun onItemClick(view: View, position: Int) {
        mainModel.playListInfo = list[position]
        mainModel.playListCount = list[position].trackCount.toInt()
        mainModel.initSongListType = TYPE_USER_PLAY_LIST
        Navigation.findNavController(requireActivity(), R.id.fragment_container)
            .navigate(R.id.action_homeFragment_to_playListFragment)
    }

    override fun onItemLongClick(view: View, position: Int) {
    }

    companion object {
        const val TAG = "HomeFragment"
    }

}