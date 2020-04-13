package com.max.template.ui.observer

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import org.greenrobot.eventbus.EventBus

class EventBusUIObserver: DefaultLifecycleObserver {
    private val defaultEventBus: EventBus by lazy {
        EventBus.getDefault()
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        if(!defaultEventBus.isRegistered(owner)) {
            defaultEventBus.register(owner)
        }
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        if(defaultEventBus.isRegistered(owner)) {
            defaultEventBus.unregister(owner)
        }
    }
}

fun LifecycleOwner.addEventBusUIObserver() {
    this.lifecycle.addObserver(EventBusUIObserver())
}