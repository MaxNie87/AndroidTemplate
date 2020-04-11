package com.max.template.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.max.template.R
import com.max.template.databinding.FragmentDashboardBinding
import com.max.template.ui.base.DaggerFragment
import com.max.template.ui.event.MessageEvent
import org.greenrobot.eventbus.EventBus

class DashboardFragment : Fragment() {
    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)

        var dataBinding = FragmentDashboardBinding.inflate(inflater, container, false).apply {
            viewModel = dashboardViewModel
            fragment = this@DashboardFragment
        }

        val textView: TextView = dataBinding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return dataBinding.root
    }

    fun postEventBus() {
        EventBus.getDefault().post(MessageEvent("This is from Event Bus Post."))
    }
}
