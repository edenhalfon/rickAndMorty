package com.ehapps.core.ui.adapter

import androidx.viewbinding.ViewBinding
import java.util.*

/**
 * [MultiTypeDelegate] that creates [NoDataViewHolder]
 * This delegate can be used when creating list for [MultiTypeAdapter] without specifying data to bind
 */
abstract class NoDataDelegate<V: ViewBinding> : MultiTypeDelegate<Unit, V, NoDataViewHolder<V>>() {
    /**
     * This delegate has an artificial identifier because there is no data
     */
    override fun getItemId(item: Unit): String = UUID.randomUUID().toString()
}