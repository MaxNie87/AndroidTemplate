package com.max.template.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject
import javax.inject.Named

//class HomeViewModel(@Inject @Named("something") var str: String) : ViewModel() {
class HomeViewModel @Inject constructor(@Named("something") var str: String) : ViewModel() {

    private var _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    var text: LiveData<String> = _text
}