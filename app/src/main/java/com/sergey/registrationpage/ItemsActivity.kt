package com.sergey.registrationpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val itemsList = findViewById<RecyclerView>(R.id.item_list)
        val items = arrayListOf<Item>()

        items.add(Item(1,"sofa","Диван", "Loram ipsum", "sed do", 33))
        items.add(Item(2,"light1","Свет", "Loram ipsum", "sed do", 44))
        items.add(Item(3,"kitchen","Кухня", "Loram ipsum", "sed do", 55))

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)
    }
}