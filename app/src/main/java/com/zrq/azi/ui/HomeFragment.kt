package com.zrq.azi.ui

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
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
import com.zrq.azi.util.Constants.USER_PLAY_LIST
import com.zrq.azi.util.ToastUtil
import com.zrq.azi.util.Util.httpGet
import okhttp3.*
import java.io.IOException


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

    @SuppressLint("NotifyDataSetChanged")
    @RequiresApi(Build.VERSION_CODES.P)
    override fun initData() {
        mAdapter = PlayListAdapter(requireContext(), list, this, this)
        mBinding.apply {
            recyclerView.adapter = mAdapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
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


        val avatarUrl = MMKV.defaultMMKV().decodeString("avatarUrl", "")
        val nickname = MMKV.defaultMMKV().decodeString("nickname", "游客登录")
        mBinding.tvUsername.text = nickname
        Glide.with(requireActivity()).load(avatarUrl).into(mBinding.ivUserHead)
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
        }
    }

    private fun exit() {
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
        val uid = MMKV.defaultMMKV().decodeString("uid", "")
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
                    requireActivity().runOnUiThread {
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
        mainModel.playListCount = list[position].trackCount
        Navigation.findNavController(requireActivity(), R.id.fragment_container)
            .navigate(R.id.action_homeFragment_to_playListFragment)
    }

    override fun onItemLongClick(view: View, position: Int) {
    }

    companion object {
        const val TAG = "HomeFragment"
    }

}