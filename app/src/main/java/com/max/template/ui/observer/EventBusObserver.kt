package com.max.template.ui.observer

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import org.greenrobot.eventbus.EventBus

class EventBusObserver: DefaultLifecycleObserver {
    private val defaultEventBus: EventBus by lazy {
        EventBus.getDefault()
    }

    override fun onCreate(owner: LifecycleOwner) {
        if(!defaultEventBus.isRegistered(owner)) {
            defaultEventBus.register(owner)
        }
    }

    override fun onDestroy(owner: LifecycleOwner) {
        if(defaultEventBus.isRegistered(owner)) {
            defaultEventBus.unregister(owner)
        }
    }
}

fun LifecycleOwner.addEventBusObserver() {
    this.lifecycle.addObserver(EventBusObserver())
}