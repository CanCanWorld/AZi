package com.zrq.azi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zrq.azi.bean.Comment
import com.zrq.azi.databinding.ItemCommentBinding
import com.zrq.azi.interfaces.OnItemClickListener
import com.zrq.azi.interfaces.OnItemLongClickListener

class CommentItemAdapter(
    private val context: Context,
    private val list: ArrayList<Comment.CommentsDTO>,
    private val onItemClickListener: OnItemClickListener,
) : RecyclerView.Adapter<VH<ItemCommentBinding>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH<ItemCommentBinding> {
        return VH(ItemCommentBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: VH<ItemCommentBinding>, position: Int) {
        val bean = list[position]
        holder.binding.apply {
            tvUsername.text = bean.user.nickname
            tvUpTime.text = bean.timeStr
            tvComment.text = bean.content
            tvUpNum.text = bean.likedCount.toString()
            Glide.with(context).load(bean.user.avatarUrl).into(ivHead)
            root.setOnClickListener {
                onItemClickListener.onItemClick(it, holder.adapterPosition)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}