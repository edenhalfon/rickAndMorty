package com.ehapps.core.ui.adapter

import androidx.viewbinding.ViewBinding

/**
 * [MultiTypeViewHolder] that has no data to bind
 */
open class NoDataViewHolder<V: ViewBinding>(viewBinding: V)
    : MultiTypeViewHolder<Unit, V>(viewBinding) {
    override fun bind(item: Unit) {
        // empty implementation
    }
}