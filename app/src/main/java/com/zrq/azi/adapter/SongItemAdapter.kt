package com.zrq.azi.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.zrq.azi.R
import com.zrq.azi.bean.Dj
import com.zrq.azi.databinding.ItemSongBinding
import com.zrq.azi.interfaces.OnItemClickListener
import com.zrq.azi.interfaces.OnItemLongClickListener
import com.zrq.azi.util.Util.formatDuration
import java.text.SimpleDateFormat

class SongItemAdapter(
    private val context: Context,
    private val list: ArrayList<Dj.ProgramsBean>,
    private val onItemClickListener: OnItemClickListener,
    private val onItemLongClickListener: OnItemLongClickListener,
) : RecyclerView.Adapter<VH<ItemSongBinding>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH<ItemSongBinding> {
        return VH(ItemSongBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holder: VH<ItemSongBinding>, position: Int) {
        val bean = list[position]
        holder.binding.apply {
            tvTitle.text = bean.name
            tvDuration.text = formatDuration(bean.duration)
            tvPlayCount.text = bean.listenerCount.toString()
            SimpleDateFormat("yyyy-MM-dd").apply {
                tvUpdateTime.text = this.format(bean.createTime)
            }
            val drawable = root.background as GradientDrawable
            drawable.color = ContextCompat.getColorStateList(root.context, R.color.app_bg)
            root.setOnClickListener {
                onItemClickListener.onItemClick(it, holder.adapterPosition)
            }
            root.setOnLongClickListener {
                onItemLongClickListener.onItemLongClick(it, holder.adapterPosition)
                true
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}