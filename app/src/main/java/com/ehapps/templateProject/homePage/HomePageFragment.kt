package com.ehapps.templateProject.homePage

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ehapps.core.domain.DomainResource
import com.ehapps.core.setGone
import com.ehapps.core.setVisible
import com.ehapps.core.ui.BaseFragment
import com.ehapps.core.ui.adapter.MultiTypeAdapter
import com.ehapps.core.ui.adapter.MultiTypeCollection
import com.ehapps.templateProject.databinding.HomePageFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomePageFragment : BaseFragment() {

    private lateinit var binding: HomePageFragmentBinding
    private val homePageViewModel: HomePageViewModel by viewModel()
    private val adapter by lazy { MultiTypeAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomePageFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        collectFlow(homePageViewModel.charactersStateFlow)

        binding.charactersList.adapter = adapter
    }

    override fun onLoading(resource: DomainResource<Any>) {
        super.onLoading(resource)
        when (HomePageViewModel.Actions.values()[resource.actionCode]) {
            HomePageViewModel.Actions.CHARACTERS -> binding.progressBar.setVisible()
        }
    }

    override fun onOperationSuccess(resource: DomainResource<Any>) {
        super.onOperationSuccess(resource)
        when (HomePageViewModel.Actions.values()[resource.actionCode]) {
            HomePageViewModel.Actions.CHARACTERS -> {
                binding.progressBar.setGone()
                adapter.setCollection(resource.data as MultiTypeCollection)

                binding.charactersList.setOnScrollChangeListener { recyclerView, i, i2, i3, i4 ->
                    val layoutManager = binding.charactersList.layoutManager as LinearLayoutManager
                    val lastVisible = layoutManager.findLastCompletelyVisibleItemPosition()
                    if (adapter.itemCount - 7 <= lastVisible) {
                        Log.d(TAG, "loading more items")
                        binding.charactersList.setOnScrollChangeListener(null)
                        homePageViewModel.loadMoreCharacters()
                    }
                }
            }
        }
    }

    override fun onOperationFailure(resource: DomainResource<Any>) {
        super.onOperationFailure(resource)

        Log.e(TAG, "onOperationFailure: ")
    }

    companion object {
        const val TAG = "HomePageFragment"
    }

}
