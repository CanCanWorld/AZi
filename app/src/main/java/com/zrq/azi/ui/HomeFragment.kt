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
import com.google.gson.Gson
import com.zrq.azi.R
import com.zrq.azi.adapter.PlayListAdapter
import com.zrq.azi.bean.UserPlayList
import com.zrq.azi.databinding.FragmentHomeBinding
import com.zrq.azi.interfaces.OnItemClickListener
import com.zrq.azi.interfaces.OnItemLongClickListener
import com.zrq.azi.util.Constants.BASE_URL
import com.zrq.azi.util.Constants.USER_PLAY_LIST
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

        }
    }

    private fun loadUserPlayList() {
        Thread {
            val url = "$BASE_URL$USER_PLAY_LIST?uid=1443709708&offset=0&limit=200"
            val request: Request = Request.Builder().url(url).get().build()
            Log.d(TAG, "loadUserPlayList: $url")
            OkHttpClient().newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                }

                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(call: Call, response: Response) {
                    if (response.body != null) {
                        val json = response.body!!.string()
                        try {
                            val playList = Gson().fromJson(json, UserPlayList::class.java)
                            if (playList?.playlist != null) {
                                mainModel.listDaoImpl?.updateAllList(playList.playlist)
                                mainModel.listDaoImpl?.let {
                                    list.clear()
                                    list.addAll(it.listAllList())
                                }
                                //存入数据库
                                requireActivity().runOnUiThread {
                                    mAdapter.notifyDataSetChanged()
                                    mBinding.refreshLayout.finishRefresh()
                                }
                            } else {
                                mBinding.refreshLayout.finishRefresh()
                            }
                        } catch (e: Exception) {
                            mBinding.refreshLayout.finishRefresh()
                            Log.d(TAG, "onResponse: $e")
                        }
                    } else {
                        mBinding.refreshLayout.finishRefresh()
                    }
                }
            })
        }.start()
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