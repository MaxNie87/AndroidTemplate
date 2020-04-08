package com.max.template.di.component

import androidx.fragment.app.Fragment
import com.max.template.di.module.FragmentModule
import com.max.template.di.module.InjectFragmentModule
import com.max.template.ui.base.DaggerFragment
import dagger.BindsInstance
import dagger.Subcomponent
import dagger.android.AndroidInjectionModule

@Subcomponent(
    modules = [
        FragmentModule::class,
        AndroidInjectionModule::class
    ]
)
interface FragmentComponent {
    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun bindFragment(fragment: Fragment): Builder

        fun build(): FragmentComponent
    }

    fun inject(fragment: DaggerFragment)
}