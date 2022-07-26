package com.ehapps.core.ui.adapter

import android.view.View
import androidx.viewbinding.ViewBinding

/**
 * T represents the data type
 * V represents the view data binding type, in other words, the XML file.
 * H represents the viewHolder type
 */
abstract class MultiTypeDelegate<T, V: ViewBinding, H: MultiTypeViewHolder<T, V>> {
    /**
     * Creates a view holder.
     * Should be called inside [RecyclerView.Adapter.onCreateViewHolder]
     */
    abstract fun createViewHolder(itemView: View): H

    /**
     * Returns a view type for this [AnyTypeAdapter] item.
     * Should be called inside [RecyclerView.Adapter.onCreateViewHolder]
     */
    abstract fun getItemViewType(): Int

    abstract fun getItemId(item: T): String

    /**
     * Binds the data to view holder
     * Should be called inside [RecyclerView.Adapter.onBindViewHolder]
     */
    fun bind(item: AdapterItem<T>, holder: H) {
        holder.bind(item.data)
    }
}