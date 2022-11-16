package com.zrq.azi.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.zrq.azi.R
import com.zrq.azi.bean.Dj
import com.zrq.azi.databinding.ItemLoveSongBinding
import com.zrq.azi.interfaces.ITouchHelper
import com.zrq.azi.interfaces.OnItemClickListener
import com.zrq.azi.util.Util.formatDuration
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class LoveItemAdapter(
    private val context: Context,
    private val list: ArrayList<Dj.ProgramsBean>,
    private val onItemClickListener: OnItemClickListener,
    private val onDataChange: (Int, Int) -> Unit,
    private val onItemDelete: (Int) -> Unit,
) : RecyclerView.Adapter<VH<ItemLoveSongBinding>>(), ITouchHelper {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH<ItemLoveSongBinding> {
        return VH(ItemLoveSongBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holder: VH<ItemLoveSongBinding>, position: Int) {
        val bean = list[position]
        holder.binding.apply {
            tvTitle.text = bean.name
            tvDuration.text = formatDuration(bean.duration)
            tvPlayCount.text = bean.listenerCount.toString()
            SimpleDateFormat("yyyy-MM-dd").apply {
                tvUpdateTime.text = this.format(bean.createTime)
            }
            val drawable = root.background as GradientDrawable
            drawable.color = ContextCompat.getColorStateList(root.context, R.color.green)
            root.setOnClickListener {
                Log.d("TAG", "onBindViewHolder: $position")
                onItemClickListener.onItemClick(it, holder.adapterPosition)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        Log.d(TAG, "fromPosition: $fromPosition, toPosition: $toPosition")
        onDataChange(fromPosition, toPosition)
        Collections.swap(list, fromPosition, toPosition)
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onItemDismiss(position: Int, viewHolder: RecyclerView.ViewHolder) {
        val drawable = viewHolder.itemView.background as GradientDrawable
        drawable.color = ContextCompat.getColorStateList(viewHolder.itemView.context, R.color.green)
        onItemDelete(position)
        list.removeAt(position)
        notifyItemRemoved(position)
    }

    companion object{
        const val TAG = "LoveItemAdapter"
    }
}