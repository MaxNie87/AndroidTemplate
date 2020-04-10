package com.max.template.di.module

import com.max.template.ui.dashboard.DashboardFragment
import com.max.template.ui.home.HomeFragment
import com.max.template.ui.notifications.NotificationsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface InjectFragmentModule {
    @ContributesAndroidInjector
    fun dashboardFragmentInjector(): DashboardFragment

    @ContributesAndroidInjector
    fun homeFragmentInjector(): HomeFragment

    @ContributesAndroidInjector
    fun notificationsFragmentInjector(): NotificationsFragment
}