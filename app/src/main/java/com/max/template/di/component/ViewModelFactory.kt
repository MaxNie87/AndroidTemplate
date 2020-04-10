package com.max.template.di.component

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.jetbrains.annotations.NotNull
import javax.inject.Inject
import javax.inject.Provider
import kotlin.reflect.KClass


class ViewModelFactory @Inject constructor(providerMap: Map<KClass<out ViewModel>, Provider<ViewModel>>) : ViewModelProvider.Factory {
    var mProviderMap: Map<KClass<out ViewModel>, Provider<ViewModel>> = providerMap

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return mProviderMap.get<Any, Provider<ViewModel>>(modelClass)?.get() as T
    }
}