package com.zrq.azi.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zrq.azi.bean.DailySongs
import com.zrq.azi.databinding.ItemListItemBinding
import com.zrq.azi.interfaces.OnItemClickListener

class DailySongsAdapter(
    private val context: Context,
    private val list: ArrayList<DailySongs.DataDTO.DailySongsDTO>,
    private val onItemClickListener: OnItemClickListener,
    private val onMoreClick: (Int) -> Unit,
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
            tvDetail.text = bean.singer + "(${bean.reason})"
            root.setOnClickListener {
                onItemClickListener.onItemClick(it, holder.adapterPosition)
            }
            ivMore.setOnClickListener {
                onMoreClick(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}