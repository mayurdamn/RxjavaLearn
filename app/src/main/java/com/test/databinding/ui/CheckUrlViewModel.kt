package com.test.databinding.ui


import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.databinding.data.db.AddUrlEmailModel

class CheckUrlViewModel(checkUrlActivity: CheckUrlActivity) : ViewModel() {

        lateinit var callBack : CheckUrlActListeners
        var listEmailUrlLiveData = MutableLiveData<ArrayList<AddUrlEmailModel>>()

        var mcontext =checkUrlActivity
        var timeFrquency : String ? =""

       fun btnExecute (view: View){

       }
       fun btn_addurl (view: View){
           var model = AddUrlEmailModel()
           var listTemp = arrayListOf(model)
           listEmailUrlLiveData.value= listTemp



       }

       fun buttonCloseApp(view: View) {
             mcontext.finish()
       }
}