package com.max.template.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.max.template.di.component.ViewModelFactory
import com.max.template.di.component.ViewModelKey
import com.max.template.ui.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Provider
import javax.inject.Singleton
import kotlin.reflect.KClass

//@Module
//class ViewModelModule {
//
//    @Provides
//    @Singleton
//    fun viewModelFactory(providerMap: Map<KClass<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>): ViewModelProvider.Factory {
//        return ViewModelFactory(providerMap)
//    }
//
//    @Provides
//    @Singleton
//    @IntoMap
//    @ViewModelKey(HomeViewModel::class)
//    fun provideHomeViewModel(str: String) = HomeViewModel(str)
//}

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey( HomeViewModel::class )
    // Bind your View Model here
    abstract fun bindMainViewModel(homeViewModel: HomeViewModel ): ViewModel

    @Binds
    abstract fun bindViewModelFactory( factory: ViewModelFactory):
            ViewModelProvider.Factory

}