package com.max.template.di.component

import android.app.Application
import com.max.template.App
import com.max.template.di.module.ApplicationModule
import com.max.template.di.module.InjectActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        InjectActivityModule::class,
        AndroidInjectionModule::class
    ]
)
interface ApplicationComponent {
    // sub component
    var activityComponentBuilder: ActivityComponent.Builder

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindApplication(app: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: App)
}