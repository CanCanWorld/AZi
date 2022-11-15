package com.zrq.azi.ui

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.zrq.azi.R
import com.zrq.azi.adapter.SongItemAdapter
import com.zrq.azi.bean.Dj
import com.zrq.azi.databinding.FragmentHomeBinding
import com.zrq.azi.interfaces.OnItemClickListener
import com.zrq.azi.interfaces.OnItemLongClickListener
import com.zrq.azi.util.Constants.BASE_URL
import com.zrq.azi.util.Constants.DJ_PROGRAM
import com.zrq.azi.util.Constants.PAGE_HOME
import okhttp3.*
import java.io.IOException


class HomeFragment : BaseFragment<FragmentHomeBinding>(), OnItemClickListener, OnItemLongClickListener {
    override fun providedViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    private val list = ArrayList<Dj.ProgramsBean>()
    private lateinit var mAdapter: SongItemAdapter
    private var offset = 1

    @RequiresApi(Build.VERSION_CODES.P)
    override fun initData() {
        setScreen()
        mAdapter = SongItemAdapter(requireContext(), list, this, this)
        mBinding.apply {
            recyclerView.adapter = mAdapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }
        list.clear()
        list.addAll(mainModel.homeList)
        loadSong()
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

                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        mBinding.fab.show()
                    } else {
                        mBinding.fab.hide()
                    }
                }
            })

            fab.setOnClickListener {
                Navigation.findNavController(requireActivity(), R.id.fragment_container)
                    .navigate(R.id.action_global_loveFragment2)
            }
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
                            requireActivity().runOnUiThread {
                                mAdapter.notifyDataSetChanged()
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
        mainModel.homeList.clear()
        mainModel.homeList.addAll(list)
        mainModel.playOfPage.postValue(PAGE_HOME)
        mainModel.position.postValue(position)
        mainModel.playerControl?.let {
            it.setList(list)
            it.play(position)
        }
    }

    override fun onItemLongClick(view: View, position: Int) {
        mainModel.songDaoImpl?.addSong(list[position])
        Toast.makeText(requireContext(), "已收藏", Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val TAG = "HomeFragment"
    }

}