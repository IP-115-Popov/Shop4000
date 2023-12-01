package com.sergey.registrationpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val title: TextView = findViewById(R.id.item_title)
        val text: TextView = findViewById(R.id.item_text)
        val bthBuy: Button = findViewById(R.id.item_button_buy)
        val bthBack: Button = findViewById(R.id.item_button_back)

        title.text = intent.getStringExtra("itemTitle")
        text.text = intent.getStringExtra("itemText")
        val item= intent.getSerializableExtra("item") as? Item

        bthBuy.setOnClickListener()
        {
            if (item == null) Toast.makeText(this, " item = null", Toast.LENGTH_LONG).show()
            item?.let{
                Basket.items.add(it);
                Toast.makeText(this, "${it.title} добавлен в корзину", Toast.LENGTH_LONG).show()
            }
        }
        bthBack.setOnClickListener()
        {
            val intent = Intent(this, ItemsActivity::class.java)

            startActivity(intent)
        }
    }
}