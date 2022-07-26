package com.ehapps.core.ui.adapter

data class AdapterItem<T>(val id: String, val data: T) {
    fun areItemsTheSame(other: AdapterItem<T>): Boolean = id == other.id
    fun areContentsTheSame(other: AdapterItem<T>): Boolean = data == other.data
}