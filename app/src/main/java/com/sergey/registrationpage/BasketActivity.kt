package com.sergey.registrationpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BasketActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basket)

        val basketList:RecyclerView = findViewById(R.id.basket_list)
        val bthToItems:Button = findViewById(R.id.basket_button_to_items)

        basketList.layoutManager = LinearLayoutManager(this)
        basketList.adapter = BasketItemsAdapter(Basket.items, this)

        bthToItems.setOnClickListener()
        {
            val intent = Intent(this, ItemsActivity::class.java)
            startActivity(intent)
        }
    }
}