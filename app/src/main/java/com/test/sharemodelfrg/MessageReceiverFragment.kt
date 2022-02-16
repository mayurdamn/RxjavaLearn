package com.test.sharemodelfrg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.test.R


class MessageReceiverFragment : Fragment() {
    lateinit var textViewReceiver :TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_receiver,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewReceiver = view.findViewById(R.id.textViewReceiver)
        var model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        model.message.observe(viewLifecycleOwner, Observer {
            textViewReceiver.text = it
        })
    }
}