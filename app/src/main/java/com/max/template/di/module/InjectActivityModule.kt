package com.max.template.di.module

import com.max.template.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface InjectActivityModule {
    @ContributesAndroidInjector
    abstract fun mainActivityInjector(): MainActivity
}