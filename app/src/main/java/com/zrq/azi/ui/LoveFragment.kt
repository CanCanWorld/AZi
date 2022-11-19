package com.zrq.azi.ui

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

    private val onDataChange: (Int, Int) -> Unit = { a, b ->
        val c = list[a]._id
        val s1 = list[a].apply { _id = list[b]._id }
        val s2 = list[b].apply { _id = c }
        mainModel.songDaoImpl?.updateSongById(s1)
        mainModel.songDaoImpl?.updateSongById(s2)
    }

    private val onItemDelete: (Int) -> Unit = {
        mainModel.songDaoImpl?.deleteSong(list[it]._id)
    }

    // todo: 数据库操作
    override fun initData() {
        list.clear()
        mainModel.songDaoImpl?.listAllSongs()?.let { list.addAll(it) }
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
        }
    }

    @RequiresApi(Build.VERSION_CODES.P)
    private fun setScreen() {
        requireActivity().window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        val lp: WindowManager.LayoutParams = requireActivity().window.attributes
        lp.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
        requireActivity().window.attributes = lp
    }

    companion object {
        const val TAG = "LoveFragment"
    }

    override fun onItemClick(view: View, position: Int) {
        mainModel.loveList.clear()
        mainModel.loveList.addAll(list)
        mainModel.playOfPage.postValue(Constants.PAGE_LOVE)
        mainModel.position.postValue(position)
        mainModel.playerControl?.let {
            it.setList(list)
            it.play(position)
            mainModel.showPlayBar()
        }
    }
}
