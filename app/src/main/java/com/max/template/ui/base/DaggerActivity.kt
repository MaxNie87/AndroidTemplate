package com.max.template.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.max.template.App
import com.max.template.di.component.ActivityComponent
import com.max.template.di.component.ApplicationComponent
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

open class DaggerActivity: AppCompatActivity(), HasAndroidInjector {
    @Inject
    lateinit var dispatchingFragmentInjector: DispatchingAndroidInjector<Any>

    private val applicationComponent: ApplicationComponent by lazy {
        val application = this.application
        if (application is App) {
            application.applicationComponent
        } else
            throw RuntimeException("${this::class.qualifiedName} application is not App's instance")
    }

    lateinit var activityComponent: ActivityComponent
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
    }

    private fun inject() {
        if(!this::activityComponent.isInitialized) {
            activityComponent = applicationComponent.activityComponentBuilder.bindActivity(this).build()
        }

        AndroidInjection.inject(this)
        activityComponent.inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingFragmentInjector
    }
}