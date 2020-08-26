package com.example.communicationwithfragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_a.*

class AFragment : Fragment() {
    var listener: OnFabolousEventListener? = null
    interface OnFabolousEventListener {
        fun onFabolousEvent(param1 : String, param2 : String)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFabolousEventListener) {
            listener = context
        } else {
            throw IllegalStateException(String.format("%s should implement %s", context.javaClass.name, OnFabolousEventListener::class.java.name))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_click.setOnClickListener {
            ///ini bisa di isi di fragment, pas ngirim data menggunakan intent, di ganti pakai ini
            listener?.onFabolousEvent("data 1","data 2")
        }
    }


}