package com.zrq.azi.interfaces

import androidx.recyclerview.widget.RecyclerView

interface ITouchHelper {
    fun onItemMove(fromPosition: Int, toPosition: Int)
    fun onItemDismiss(position: Int, viewHolder: RecyclerView.ViewHolder)
}