package com.sergey.registrationpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val title: TextView = findViewById(R.id.item_title)
        val text: TextView = findViewById(R.id.item_text)
        val bthBuy: Button = findViewById(R.id.item_button_buy)

        title.text = intent.getStringExtra("itemTitle")
        text.text = intent.getStringExtra("itemText")
    }
}