package com.max.template.di.module

import android.content.Context
import android.location.LocationManager
import com.max.template.App
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApplicationModule {
    @Provides
    @Singleton
    fun provideLocationManager(app: App): LocationManager = app.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    @Provides
    @Singleton
    @Named("something")
    fun provideSomething(): String = "something1"

    @Provides
    @Singleton
    @Named("somethingElse")
    fun provideSomethingElse(): String = "somethingElse1"
}