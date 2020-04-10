package com.max.template.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.max.template.R
import com.max.template.databinding.FragmentHomeBinding
import com.max.template.di.component.ViewModelFactory
import com.max.template.ui.base.DaggerFragment
import javax.inject.Inject
import javax.inject.Named

class HomeFragment : DaggerFragment() {
    @Inject
    @Named("something")
    lateinit var str: String

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        var dataBinding = FragmentHomeBinding.inflate(inflater, container, false)
        homeViewModel =
                ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)

        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            dataBinding.textHome.text = it
        })

        return dataBinding.root
    }
}
