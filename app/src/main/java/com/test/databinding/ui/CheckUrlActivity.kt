package com.test.databinding.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.R
import com.test.databinding.ActivityCheckUrlBinding
import com.test.databinding.Util.toast
import com.test.databinding.data.db.AddUrlEmailModel

class CheckUrlActivity : AppCompatActivity(),CheckUrlActListeners {
    lateinit var vModel : CheckUrlViewModel
    lateinit var binding: ActivityCheckUrlBinding
    lateinit var adapter : AddUrlEmailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_url)
         binding = DataBindingUtil.setContentView(this,R.layout.activity_check_url)

         vModel = CheckUrlViewModel(this)
         binding.homeclick=vModel
         vModel.callBack=this
         binding.lifecycleOwner = this

        initRecyclerView()


    }

    private fun observeData() {

        vModel.listEmailUrlLiveData.observe(this, Observer {
            //listItem.add(0,it[0])
            adapter.setList(it)
            adapter.notifyItemChanged(0)

        })
    }

    override fun showError(message: String) {
       // Toast.makeText(this@CheckUrl,message,Toast.LENGTH_LONG ).show()
        toast(message)
    }

    override fun buttonCallBack(view: View) {

    }

    private fun initRecyclerView(){
        binding.recyclerViewUrlList.layoutManager = LinearLayoutManager(this)
        adapter = AddUrlEmailAdapter(this@CheckUrlActivity,vModel)
        binding.recyclerViewUrlList.adapter=adapter
        observeData()

    }

    private fun dumylistList() :ArrayList<AddUrlEmailModel>{
        var item =ArrayList<AddUrlEmailModel>()
        var model = AddUrlEmailModel()
        item.add(model)
        return item
    }



    /*private fun listItemClicked(subscriber: Subscriber){
        AddUrlEmailModel.initUpdateAndDelete(subscriber)
    }*/
}