package com.max.template.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import com.max.template.R
import com.max.template.databinding.FragmentDashboardBinding
import com.max.template.ui.base.DaggerFragment
import com.max.template.ui.event.MessageEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.greenrobot.eventbus.EventBus

class DashboardFragment : Fragment() {
    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var dataBinding: FragmentDashboardBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)

        dataBinding = FragmentDashboardBinding.inflate(inflater, container, false).apply {
            viewModel = dashboardViewModel
            fragment = this@DashboardFragment
        }

        val textView: TextView = dataBinding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return dataBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadDataWithCoroutine()
    }

    fun postEventBus() {
        EventBus.getDefault().post(MessageEvent("This is from Event Bus Post."))
    }

    private fun loadDataWithCoroutine() {
        lifecycleScope.launch {
            val result = withContext(Dispatchers.IO) {
                Thread.sleep(2 * 1000)
                "Coroutine Operation"
            }

            dataBinding.textDashboard.text = result
        }
    }
}
