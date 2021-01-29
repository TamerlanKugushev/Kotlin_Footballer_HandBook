package com.example.kotlin_footballer_handbook

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(list: ArrayList<ListItem>, context: Context) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    var listR = list
    var contextR = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(contextR).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listR.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listItemR = listR[position]
        holder.bind(listItemR, contextR)

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle = view.findViewById<TextView>(R.id.tvTitleContentLayout)
        val tvContent = view.findViewById<TextView>(R.id.tvContentContentLayout)
        val im = view.findViewById<ImageView>(R.id.imContentLayout)

        fun bind(listItem: ListItem, context: Context) {
            tvTitle.text = listItem.titleText
            tvContent.text = listItem.contentText
            im.setImageResource(listItem.image_id)
            itemView.setOnClickListener {
                Toast.makeText(context, "Pressed : ${tvTitle.text}", Toast.LENGTH_SHORT).show()
                val intent = Intent(context, ContentActivity::class.java).apply {
                    putExtra("title", tvTitle.text.toString())
                    putExtra("content", tvContent.text.toString())
                    putExtra("image", listItem.image_id)
                }
                context.startActivity(intent)

            }
        }
    }

    fun updateAdapter(list: List<ListItem>) {
        listR.clear()
        listR.addAll(list)
        notifyDataSetChanged()
    }
}