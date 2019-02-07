package com.example.internettime

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import org.jetbrains.anko.find
import java.nio.file.Files.find

class FragmentHome : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = TaskListAdapter(this.context!!)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        return view
    }

    companion object {
        fun newInstance(): FragmentHome = FragmentHome()
    }
}
