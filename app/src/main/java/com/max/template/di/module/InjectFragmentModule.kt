package com.max.template.di.module

import com.max.template.ui.dashboard.DashboardFragment
import com.max.template.ui.home.HomeFragment
import com.max.template.ui.notifications.NotificationsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface InjectFragmentModule {
    @ContributesAndroidInjector
    abstract fun dashboardFragmentInjector(): DashboardFragment

    @ContributesAndroidInjector
    abstract fun homeFragmentInjector(): HomeFragment

    @ContributesAndroidInjector
    abstract fun notificationsFragmentInjector(): NotificationsFragment
}