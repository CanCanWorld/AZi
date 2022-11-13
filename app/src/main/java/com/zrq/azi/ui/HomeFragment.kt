package com.zrq.azi.ui

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.gson.Gson
import com.zrq.azi.adapter.DragCallBack
import com.zrq.azi.adapter.SongItemAdapter
import com.zrq.azi.adapter.ViewpagerAdapter
import com.zrq.azi.bean.Dj
import com.zrq.azi.databinding.FragmentHomeBinding
import com.zrq.azi.interfaces.IPlayerViewControl
import com.zrq.azi.interfaces.OnItemClickListener
import com.zrq.azi.util.Constants.BASE_URL
import com.zrq.azi.util.Constants.DJ_PROGRAM
import com.zrq.azi.view.VisualizeView
import okhttp3.*
import java.io.IOException


class HomeFragment : BaseFragment<FragmentHomeBinding>(), OnItemClickListener, IPlayerViewControl {
    override fun providedViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    private val list = ArrayList<Dj.ProgramsBean>()
    private lateinit var mAdapter: SongItemAdapter
    private lateinit var mVpAdapter: ViewpagerAdapter
    private var offset = 1

    @RequiresApi(Build.VERSION_CODES.P)
    override fun initData() {
        setScreen()
        Thread {
            for (i in 1..10) {
                mainModel.playerControl?.registerViewControl(this)
                Log.d(TAG, "initData: ${mainModel.playerControl}")
                Thread.sleep(1000)
            }
        }.start()
        mAdapter = SongItemAdapter(requireContext(), list, this)
        mVpAdapter = ViewpagerAdapter(requireActivity(), list)
        mBinding.apply {
            recyclerView.adapter = mAdapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            viewPager.adapter = mVpAdapter
            val dragCallBack = DragCallBack(mAdapter, list)
            val itemTouchHelper = ItemTouchHelper(dragCallBack)
            itemTouchHelper.attachToRecyclerView(mBinding.recyclerView)
        }
        loadSong()
        mBinding.visualizeView.setMode(VisualizeView.SINGLE)
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
            viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    Log.d(TAG, "onPageSelected: $position")
                    mainModel.playerControl?.let {
                        it.setList(list)
                        it.play(position)
                    }
                }
            })

            refreshLayout.setOnRefreshListener {
                offset = 1
                loadSong()
            }

            refreshLayout.setOnLoadMoreListener {
                offset++
                loadSong()
            }

            recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                @RequiresApi(Build.VERSION_CODES.P)
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (dy > 40) {
                        setScreen()
                    }
                }
            })
        }
    }


    private fun loadSong() {
        Thread {
            val url = "$BASE_URL$DJ_PROGRAM?rid=971535834&limit=${40 * offset}"
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
                        val dj = Gson().fromJson(json, Dj::class.java)
                        if (dj?.programs != null) {
                            list.clear()
                            list.addAll(dj.programs)
                            mainModel.list.postValue(list)
                            requireActivity().runOnUiThread {
                                mAdapter.notifyDataSetChanged()
                                mVpAdapter.notifyDataSetChanged()
                                mBinding.refreshLayout.finishRefresh()
                                mBinding.refreshLayout.finishLoadMore()
                            }
                        } else {
                            mBinding.refreshLayout.finishRefresh()
                            mBinding.refreshLayout.finishLoadMore()
                        }
                    } else {
                        mBinding.refreshLayout.finishRefresh()
                        mBinding.refreshLayout.finishLoadMore()
                    }
                }
            })
        }.start()
    }

    override fun onItemClick(view: View, position: Int) {
        mainModel.position.postValue(position)
        mBinding.viewPager.setCurrentItem(position, false)
        mainModel.playerControl?.let {
            it.setList(list)
            it.play(position)
        }
    }

    override fun onSeekChange(progress: Int, elapsedTime: Int) {
    }

    override fun onSongPlayOver(position: Int) {
        mBinding.viewPager.setCurrentItem(position, true)
    }

    override fun onVisualizeView(mode: FloatArray) {
        mBinding.visualizeView.setData(mode)
    }

    companion object {
        const val TAG = "HomeFragment"
    }

}