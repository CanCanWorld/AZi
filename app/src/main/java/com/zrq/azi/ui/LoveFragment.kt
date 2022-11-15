package com.zrq.azi.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.zrq.azi.R
import com.zrq.azi.adapter.DragCallBack
import com.zrq.azi.adapter.LoveItemAdapter
import com.zrq.azi.bean.Dj
import com.zrq.azi.databinding.FragmentLoveBinding
import com.zrq.azi.interfaces.OnItemClickListener
import com.zrq.azi.util.Constants

class LoveFragment : BaseFragment<FragmentLoveBinding>(), OnItemClickListener {
    override fun providedViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentLoveBinding {
        return FragmentLoveBinding.inflate(LayoutInflater.from(requireContext()), container, false)
    }

    private val list = ArrayList<Dj.ProgramsBean>()
    private lateinit var adapter: LoveItemAdapter
    private val onDataChange: (ArrayList<Dj.ProgramsBean>) -> Unit = {

    }

    private val onItemDelete: (Int) -> Unit = {

    }

    // todo: 数据库操作
    override fun initData() {
        list.clear()
        mainModel.songDaoImpl?.listAllSongs()?.let { list.addAll(it) }
        mainModel.loveList.clear()
        mainModel.loveList.addAll(list)
        adapter = LoveItemAdapter(requireContext(), list, this, onDataChange, onItemDelete)
        mBinding.apply {
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            val dragCallBack = DragCallBack(adapter, list)
            val itemTouchHelper = ItemTouchHelper(dragCallBack)
            itemTouchHelper.attachToRecyclerView(mBinding.recyclerView)
        }
    }

    override fun initEvent() {
        mBinding.apply {
            fab.setOnClickListener {
                Navigation.findNavController(requireActivity(), R.id.fragment_container)
                    .navigate(R.id.action_global_homeFragment)
            }
        }
    }

    companion object {
        const val TAG = "LoveFragment"
    }

    override fun onItemClick(view: View, position: Int) {
        mainModel.playOfPage.postValue(Constants.PAGE_LOVE)
        mainModel.position.postValue(position)
        mainModel.playerControl?.let {
            it.setList(list)
            it.play(position)
        }
    }
}
