package com.hamara.testapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ImageAdapter(var list:ArrayList<Int>): RecyclerView.Adapter<ImageAdapter.ItemViewHolder>() {

    class ItemViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView) {

        val image = ItemView.findViewById<ImageView>(R.id.image)
        //val textItem = ItemView.findViewById<TextView>(R.id.count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.img_item_layout,parent,false)

        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        Glide.with(holder.image).load(R.drawable.ic_baseline_sports_baseball_24).into(holder.image)
        //holder.image.visibility = View.VISIBLE
        //holder.textItem.text = list[position].toString()
    }

    override fun getItemCount(): Int  = list.size

    fun updateItem(item:ArrayList<Int>){
        this.list = item
        notifyDataSetChanged()
    }

}