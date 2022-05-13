package com.test.databinding.ui

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.ViewUtils
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.test.R
import com.test.databinding.ListitemUrlEmailBinding
import com.test.databinding.data.db.AddUrlEmailModel

data class AddUrlEmailAdapter(var mContext: Context, val vModel: CheckUrlViewModel):RecyclerView.Adapter<AddUrlEmailAdapter.MainViewHolder>() {
    var listItem:ArrayList<AddUrlEmailModel> = ArrayList()
    var focus =false
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val binding :ListitemUrlEmailBinding = DataBindingUtil.inflate(layoutInflater, R.layout.listitem_url_email, parent, false)
        return MainViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
             //holder.bind(listItem[position])
             holder.binding.imageRemove.setOnClickListener {
                      listItem.removeAt(position)
                      notifyItemRemoved(position)

             }
        (listItem[position].last_status+"-"+position).also { holder.binding.textViewStatus.text = it }

    }

    override fun getItemCount(): Int {
         return listItem.size
    }

    fun setList(urlEmailListItem: List<AddUrlEmailModel>) {
        if(listItem.size<2){
            Log.e("urlEmailListItem","not able to add")
        }else{

            listItem.addAll(0,urlEmailListItem)
        }

    }

    class MainViewHolder(val binding: ListitemUrlEmailBinding) : RecyclerView.ViewHolder(binding.root) {
           /*fun bind(listItem : AddUrlEmailModel){
                binding.imageRemove.setOnClickListener {

                }
           }*/


    }
}