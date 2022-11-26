package com.zrq.azi.ui

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.zrq.azi.R
import com.zrq.azi.adapter.CommentItemAdapter
import com.zrq.azi.bean.Comment
import com.zrq.azi.databinding.FragmentCommentBinding
import com.zrq.azi.interfaces.OnItemClickListener
import com.zrq.azi.util.Constants.BASE_URL
import com.zrq.azi.util.Constants.COMMENT
import com.zrq.azi.util.Util.httpGet

class CommentFragment : BaseFragment<FragmentCommentBinding>(), OnItemClickListener {
    override fun providedViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentCommentBinding {
        return FragmentCommentBinding.inflate(inflater, container, false)
    }

    private lateinit var mAdapter: CommentItemAdapter
    private val list = ArrayList<Comment.CommentsDTO>()
    private var offset = 0
    private var limit = 30
    private var commentId = 0L

    override fun initData() {
        commentId = mainModel.commentId
        mAdapter = CommentItemAdapter(requireContext(), list, this)
        mBinding.apply {
            recyclerView.adapter = mAdapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }
        loadComment()
    }

    override fun initEvent() {

        mBinding.apply {

            refreshLayout.setOnRefreshListener {
                offset = 0
                loadComment()
            }

            refreshLayout.setOnLoadMoreListener {
                offset++
                loadComment()
            }

            btnBack.setOnClickListener {
                Navigation.findNavController(requireActivity(), R.id.fragment_container)
                    .popBackStack()
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
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        mBinding.btnBack.show()
                    } else {
                        mBinding.btnBack.hide()
                        /////////////////////////////////////////
                        /**
                         * Copy Revision Number
                        Ctrl+Alt+Shift+C
                        Create Patch...
                        Cherry-Pick
                        Checkout Revision "b27e1a55
                        Show Repository at Revision
                        Compare with Local
                        Reset Current Branch to Here..
                        Revert Commit
                        Undo Commit..
                        Edit Commit Message..
                        Fixup.
                        Squash Into.
                        Drop Commit
                        Interactively Rebase from Here..
                        Branch "origin/main
                        New Branch...
                        New Tag..
                        Go to Child Commit
                        Go to Parent Commit
                        向左箭头
                        向右箭头
                        Open on GitHub
                         */
                    }
                }
            })
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun loadComment() {
        val url = "$BASE_URL$COMMENT?id=$commentId&limit=$limit&offset=${offset * limit}"
        httpGet(url) { success, msg ->
            if (success) {
                val comment = Gson().fromJson(msg, Comment::class.java)
                if (comment?.comments != null) {
                    if (offset == 0)
                        list.clear()
                    list.addAll(comment.comments)
                    mAdapter.notifyDataSetChanged()
                }
            } else {
                Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
            }
            mBinding.refreshLayout.finishRefresh()
            mBinding.refreshLayout.finishLoadMore()
        }
    }

    override fun onItemClick(view: View, position: Int) {

    }

    companion object {
        const val TAG = "CommentFragment"
    }
}