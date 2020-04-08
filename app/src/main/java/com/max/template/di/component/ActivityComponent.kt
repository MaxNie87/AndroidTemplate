package com.max.template.di.component

import android.app.Activity
import com.max.template.di.module.ActivityModule
import com.max.template.di.module.InjectFragmentModule
import com.max.template.di.scope.ActivityScope
import com.max.template.ui.base.DaggerActivity
import dagger.BindsInstance
import dagger.Subcomponent
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule

@ActivityScope
@Subcomponent(
    modules = [
        ActivityModule::class,
        InjectFragmentModule::class,
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class
    ]
)
open interface ActivityComponent {
    var fragmentComponentBuilder: FragmentComponent.Builder

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun bindActivity(activity: Activity): Builder

        fun build(): ActivityComponent
    }

    fun inject(activity: DaggerActivity)
}