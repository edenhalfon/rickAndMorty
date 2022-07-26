package com.ehapps.core.ui.adapter

import androidx.viewbinding.ViewBinding

data class AdapterItemMetaData<T, V: ViewBinding>(
    val position: Int,
    val delegate: MultiTypeDelegate<T, V, MultiTypeViewHolder<T, V>>
)