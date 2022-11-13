package com.zrq.azi.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zrq.azi.bean.Dj
import com.zrq.azi.databinding.ItemSongBinding
import com.zrq.azi.interfaces.OnItemClickListener
import java.text.SimpleDateFormat

class SongItemAdapter(
    private val context: Context,
    private val list: ArrayList<Dj.ProgramsBean>,
    private val onItemClickListener: OnItemClickListener,
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
            root.setOnClickListener {
                onItemClickListener.onItemClick(it, position)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun formatDuration(duration: Int): String {
        if (duration == 0) return "00:00"
        val m = duration / (60 * 1000)
        val s = (duration - 60 * 1000 * m) / 1000
        return String.format("%02d", m) + ":" + String.format("%02d", s)
    }
}