package com.max.template.ui.base

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.max.template.App
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import org.greenrobot.eventbus.EventBus

open class DaggerFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EventBus.getDefault().register(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}