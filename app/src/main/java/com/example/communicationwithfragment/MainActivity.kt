package com.example.communicationwithfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), AFragment.OnFabolousEventListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.parent, AFragment()).commit()

    }

    override fun onFabolousEvent(param1: String, param2: String) {
        //disini nannti untu ambil nilai yang akan di tampilkan di adapter
            Toast.makeText(this," test data $param1 dan param2 $param2",Toast.LENGTH_LONG).show()
    }

    override fun onAttachFragment(fragment: Fragment) {
        super.onAttachFragment(fragment)
        when {
            fragment is AFragment -> fragment.listener = this
        }
    }
}