package com.sergey.registrationpage

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BasketItemsAdapter(var items: MutableList<Item>, var context: Context): RecyclerView.Adapter<BasketItemsAdapter.MyViewHolder>() {
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.basket_items_img)
        val title: TextView = view.findViewById(R.id.basket_items_title)
        val prise: TextView = view.findViewById(R.id.basket_items_prise)
        val btnDel: Button = view.findViewById(R.id.basket_items_button_del)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_in_basket_list, parent,false)
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = items[position].title
        holder.prise.text = items[position].price.toString()


        var imageId = context.resources.getIdentifier(
            items[position].image,
            "drawable",
            context.packageName
        )

        holder.img.setImageResource(imageId)

        holder.btnDel.setOnClickListener()
        {
            items.removeAt(position)
            notifyItemRemoved(holder.getAdapterPosition())
        }
    }
    override fun getItemCount(): Int {
        return items.count()
    }


}