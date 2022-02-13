package com.test.sharemodelfrg

import android.arch.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val message = MutableLiveData<String>()

    fun sendMessage(text: String){
         message.value=text
    }
}