package com.example.internettime

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class FragmentDashboard : Fragment() {

    /*override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_dashboard, container, false)*/

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val btn = view.findViewById<Button>(R.id.btnService)
        btn.setOnClickListener {
            startService()
        }
        return view
    }

    private fun startService(){
        Log.d("FragmentDashboard", "startService")
        val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
        startActivity(intent)
    }

    companion object {
        fun newInstance(): FragmentDashboard = FragmentDashboard()
    }
}
