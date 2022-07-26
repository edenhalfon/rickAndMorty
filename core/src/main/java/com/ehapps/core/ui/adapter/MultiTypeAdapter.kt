package com.ehapps.core.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.*

open class MultiTypeAdapter : RecyclerView.Adapter<MultiTypeViewHolder<Any, ViewBinding>>(),
    CoroutineScope by MainScope() {
    protected var multiTypeCollection: MultiTypeCollection = MultiTypeCollection.EMPTY
    private var diffJob: Job? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MultiTypeViewHolder<Any, ViewBinding> {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return multiTypeCollection.currentItemViewTypeDelegate.createViewHolder(view)
    }

    override fun onBindViewHolder(holder: MultiTypeViewHolder<Any, ViewBinding>, position: Int) {
        with(multiTypeCollection) {
            currentItemViewTypeDelegate.bind(items[position], holder)
        }
    }

    override fun getItemCount(): Int = multiTypeCollection.size

    override fun getItemViewType(position: Int): Int {
        return with(multiTypeCollection) {
            findCurrentItemViewTypePosition(positionsRanges, position)
                .also { currentItemViewTypePosition = it }
                .let { currentItemViewTypeDelegate.getItemViewType() }
        }
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        cancel()
    }

    fun setCollection(
        collection: MultiTypeCollection,
        onUpdatesDispatch: ((MultiTypeCollection) -> Unit)? = null
    ) {
        val adapter = this
        diffJob?.cancel()
        diffJob = launch {
            val diffResult = withContext(Dispatchers.Default) {
                DiffUtil.calculateDiff(
                    DiffUtilCallback(
                        multiTypeCollection.items,
                        collection.items
                    )
                )
            }
            multiTypeCollection = collection
            diffResult.dispatchUpdatesTo(adapter)
            onUpdatesDispatch?.invoke(collection)
        }
    }

    private fun findCurrentItemViewTypePosition(
        positionsRanges: List<IntRange>,
        adapterPosition: Int
    ): Int {
        return with(positionsRanges) {
            binarySearch {
                when {
                    adapterPosition in it -> 0
                    adapterPosition < it.first -> 1
                    else -> -1
                }
            }
        }
    }

    private class DiffUtilCallback(
        private val oldList: List<AdapterItem<Any>>,
        private val newList: List<AdapterItem<Any>>
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition].areItemsTheSame(newList[newItemPosition])

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition].areContentsTheSame(newList[newItemPosition])
    }
}