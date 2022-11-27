package com.zrq.azi.ui

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.zrq.azi.R
import com.zrq.azi.adapter.DailyListAdapter
import com.zrq.azi.bean.DailyList
import com.zrq.azi.bean.Song
import com.zrq.azi.databinding.FragmentDailyListBinding
import com.zrq.azi.interfaces.OnItemClickListener
import com.zrq.azi.util.Constants
import com.zrq.azi.util.Constants.BASE_URL
import com.zrq.azi.util.Constants.DAILY_LIST
import com.zrq.azi.util.Util
import java.util.*
import kotlin.collections.ArrayList

class DailyListFragment : BaseFragment<FragmentDailyListBinding>(), OnItemClickListener {
    override fun providedViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentDailyListBinding {
        return FragmentDailyListBinding.inflate(inflater, container, false)
    }

    private val mList = ArrayList<DailyList.RecommendBean>()
    private lateinit var mAdapter: DailyListAdapter

    override fun initData() {
        mAdapter = DailyListAdapter(requireContext(), mList, this)
        mBinding.apply {
            recyclerView.adapter = mAdapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }
        loadDailyList()
    }

    override fun initEvent() {
        mBinding.apply {
            refreshLayout.setOnRefreshListener {
                loadDailyList()
            }

            refreshLayout.setOnLoadMoreListener {
                mBinding.refreshLayout.finishLoadMore()
            }

            btnBack.setOnClickListener {
                Navigation.findNavController(requireActivity(), R.id.fragment_container)
                    .popBackStack()
            }
        }
    }


    @SuppressLint("NotifyDataSetChanged")
    private fun loadDailyList() {
        val url = "$BASE_URL$DAILY_LIST"
        Util.httpGet(url) { success, msg ->
            if (success) {
                Log.d(TAG, "loadDailyList: $msg")
                val dailyList = Gson().fromJson(msg, DailyList::class.java)
                if (dailyList?.recommend != null) {
                    mList.clear()
                    mList.addAll(dailyList.recommend)
                    Handler(Looper.getMainLooper()).post {
                        mAdapter.notifyDataSetChanged()
                    }
                }
            } else {
                Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
            }
            mBinding.refreshLayout.finishRefresh()
            mBinding.refreshLayout.finishLoadMore()
        }
    }

    companion object {
        const val TAG = "DailyListFragment"
    }

    override fun onItemClick(view: View, position: Int) {
        mainModel.listID = mList[position].id
        mainModel.playListCount = mList[position].trackCount.toInt()
        mainModel.initSongListType = Constants.TYPE_DAILY_LIST
        Navigation.findNavController(requireActivity(), R.id.fragment_container)
            .navigate(R.id.playListFragment)
    }

}