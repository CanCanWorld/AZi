package com.zrq.azi.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class VH<T : ViewBinding?>(val binding: T) : RecyclerView.ViewHolder(binding!!.root)