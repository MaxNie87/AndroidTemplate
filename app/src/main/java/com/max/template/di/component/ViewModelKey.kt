package com.max.template.di.component

import dagger.MapKey
import kotlin.reflect.KClass
import androidx.lifecycle.ViewModel as ViewModel

@Target(AnnotationTarget.FUNCTION)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)