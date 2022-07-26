package com.ehapps.core.ui.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class MultiTypeViewHolder<T, V : ViewBinding>(val binding: V) :
    RecyclerView.ViewHolder(binding.root) {
    protected val context: Context = itemView.context

    /**
     * Sets the item fields values to views
     */
    abstract fun bind(item: T)
}