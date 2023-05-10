package com.hamara.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var count = 1
    var previous_count = 0
    var list = ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val imgRecyclerView = findViewById<RecyclerView>(R.id.imgRecyclerView)
        val adapter = ItemAdapter(ArrayList())
        val imgAdapter = ImageAdapter(ArrayList())
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        imgRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        recyclerView.adapter = adapter
        imgRecyclerView.adapter = imgAdapter

        val multiply = findViewById<Button>(R.id.button)
        multiply.setOnClickListener {
            val size = multiply()
            list.add(size)
            adapter.updateItem(list)
            imgAdapter.updateItem(list)}
    }

    fun multiply():Int{
        val temp = previous_count
        previous_count = count
        count += temp
        return count
    }
    //0,1,1,2,3,5
}