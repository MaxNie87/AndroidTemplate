package com.max.template

import android.app.Application
import com.max.template.di.component.ApplicationComponent
import com.max.template.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import javax.inject.Inject

class App : Application(), HasAndroidInjector, CoroutineScope by MainScope() {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        inject()
    }

    private fun inject() {
        if(!this::applicationComponent.isInitialized) {
            applicationComponent = DaggerApplicationComponent.builder().bindApplication(this).build()
        }

        applicationComponent.inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }
}