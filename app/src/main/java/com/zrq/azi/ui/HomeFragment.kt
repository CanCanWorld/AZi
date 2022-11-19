package com.zrq.azi.ui

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
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

    @RequiresApi(Build.VERSION_CODES.P)
    override fun initData() {
        setScreen()
        mAdapter = PlayListAdapter(requireContext(), list, this, this)
        mBinding.apply {
            recyclerView.adapter = mAdapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }
        if (mainModel.homeListCache.size == 0) {
            loadUserPlayList()
        } else {
            list.clear()
            list.addAll(mainModel.homeListCache)
        }
    }

    @RequiresApi(Build.VERSION_CODES.P)
    private fun setScreen() {
        requireActivity().window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        val lp: WindowManager.LayoutParams = requireActivity().window.attributes
        lp.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
        requireActivity().window.attributes = lp
    }

    override fun initEvent() {
        mBinding.apply {

            recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                @RequiresApi(Build.VERSION_CODES.P)
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (dy > 40) {
                        setScreen()
                    }
                }

                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                }
            })

        }
    }

    private fun loadUserPlayList() {
        Thread {
            Log.d(TAG, "loadUserPlayList: ")
            val url = "$BASE_URL$USER_PLAY_LIST?uid=1443709708&offset=0&limit=200"
            val request: Request = Request.Builder()
                .url(url)
                .get()
                .build()
            OkHttpClient().newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                }

                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(call: Call, response: Response) {
                    if (response.body != null) {
                        val json = response.body!!.string()
                        Log.d(TAG, "onResponse: $json")
                        try {
                            val dj = Gson().fromJson(json, UserPlayList::class.java)
                            Log.d(TAG, "onResponse: ${dj.playlist}")
                            if (dj?.playlist != null) {
                                list.clear()
                                list.addAll(dj.playlist)
                                Log.d(TAG, "onResponse: $list")
                                mainModel.homeListCache.clear()
                                mainModel.homeListCache.addAll(list)
                                requireActivity().runOnUiThread {
                                    mAdapter.notifyDataSetChanged()
                                }
                            } else {
                            }
                        } catch (e: Exception) {
                            Log.d(TAG, "onResponse: $e")
                        }
                    } else {
                    }
                }
            })
        }.start()
    }

    override fun onItemClick(view: View, position: Int) {
    }

    override fun onItemLongClick(view: View, position: Int) {
    }

    companion object {
        const val TAG = "HomeFragment"
    }

}