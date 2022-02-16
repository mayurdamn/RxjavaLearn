package com.test.sharemodelfrg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.test.R


class MessageSenderFragment : Fragment() {
    lateinit var button :Button
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sender, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button = view.findViewById(R.id.button)
        var model =ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        button.setOnClickListener {
            model.sendMessage("Hello dear ")
        }
    }
}