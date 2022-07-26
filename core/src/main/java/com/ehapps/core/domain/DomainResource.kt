package com.ehapps.core.domain

sealed class DomainResource<out T>(
    val actionCode: Int,
    val data: T? = null,
    val message: String? = null
) {
    class Success<out T>(data: T, actionCode: Int) : DomainResource<T>(actionCode, data)
    class Loading<out T>(data: T? = null, actionCode: Int) : DomainResource<T>(actionCode, data)

    class Error<out T>(message: String, actionCode: Int, data: T? = null) :
        DomainResource<T>(actionCode, data, message)
}
