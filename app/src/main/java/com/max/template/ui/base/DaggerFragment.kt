package com.max.template.ui.base

import android.content.Context
import androidx.fragment.app.Fragment
import com.max.template.App
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection

open class DaggerFragment: Fragment() {
    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}