package com.example.recyclerview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var items : ArrayList<String>
    private lateinit var mainContext : Context
    private lateinit var mainLw : ListView
    private lateinit var listViewAdapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainContext = this@MainActivity

        items = ArrayList()

        for (i in 1..20){
            items.add("$i. Student")
        }

        listViewAdapter = ArrayAdapter<String>(mainContext, R.layout.item_layout,items)


        initViews()
    }

    private fun initViews(){
        mainLw = findViewById(R.id.lw_main)

        mainLw.adapter = listViewAdapter

        mainLw.setOnItemClickListener{parent, view, position, id ->
            Toast.makeText(mainContext, "${items[position]}", Toast.LENGTH_SHORT).show()
        }
    }
}