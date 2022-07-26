package com.ehapps.core.ui

import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.ehapps.core.data.Resource
import com.ehapps.core.domain.DomainResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

open class BaseFragment: Fragment() {


    fun collectFlow(flow: Flow<DomainResource<Any>>) {
        lifecycleScope.launchWhenStarted {
            flow.collect {
                when (it) {
                    is DomainResource.Success -> onOperationSuccess(it)
                    is DomainResource.Error -> onOperationFailure(it)
                    is DomainResource.Loading -> onLoading(it)
                }
            }
        }
    }


    open fun onLoading(resource: DomainResource<Any>) {}

    open fun onOperationSuccess(resource: DomainResource<Any>) {}

    open fun onOperationFailure(resource: DomainResource<Any>) {}
}