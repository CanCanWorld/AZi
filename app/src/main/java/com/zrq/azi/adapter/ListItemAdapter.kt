package com.zrq.azi.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zrq.azi.bean.SongOfList
import com.zrq.azi.databinding.ItemListItemBinding
import com.zrq.azi.interfaces.OnItemClickListener
import com.zrq.azi.interfaces.OnItemLongClickListener

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
            tvNumber.text = (position + 1).toString()
            if (bean.tns?.get(0) == null)
                tvSongName.text = bean.name
            else
                tvSongName.text = bean.name + "(${bean.tns[0]})"
            tvDetail.text = bean.singer
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