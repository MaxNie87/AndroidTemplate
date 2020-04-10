package com.max.template.di.component

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.max.template.ui.home.HomeViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Provider
import kotlin.reflect.KClass

@Module
class ViewModelModule {
    @Provides
    fun viewModelFactory(providerMap: Map<KClass<out ViewModel>, Provider<ViewModel>>): ViewModelProvider.Factory {
        return ViewModelFactory(providerMap)
    }

    @Provides
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun getHomeViewModel(str: String): ViewModel {
        return HomeViewModel(str)
    }
}