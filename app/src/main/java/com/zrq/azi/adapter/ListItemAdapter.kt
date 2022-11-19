package com.zrq.azi.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zrq.azi.R
import com.zrq.azi.bean.Dj
import com.zrq.azi.bean.SongOfList
import com.zrq.azi.bean.UserPlayList
import com.zrq.azi.databinding.ItemListItemBinding
import com.zrq.azi.databinding.ItemPlayListBinding
import com.zrq.azi.databinding.ItemSongBinding
import com.zrq.azi.interfaces.OnItemClickListener
import com.zrq.azi.interfaces.OnItemLongClickListener
import com.zrq.azi.util.Util.formatDuration
import java.text.SimpleDateFormat

class ListItemAdapter(
    private val context: Context,
    private val list: ArrayList<SongOfList.SongsDTO>,
    private val onItemClickListener: OnItemClickListener,
    private val onItemLongClickListener: OnItemLongClickListener,
) : RecyclerView.Adapter<VH<ItemListItemBinding>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH<ItemListItemBinding> {
        return VH(ItemListItemBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    override fun onBindViewHolder(holder: VH<ItemListItemBinding>, position: Int) {
        val bean = list[position]
        holder.binding.apply {
            tvTitle.text = bean.name
            tvDetail.text = "共${bean.trackCount}首歌"
            Glide.with(context).load(bean.coverImgUrl).into(ivAlbum)
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