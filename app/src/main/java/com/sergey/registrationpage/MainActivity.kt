package com.sergey.registrationpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userLogin = findViewById<EditText>(R.id.user_login)
        val userEmail = findViewById<EditText>(R.id.user_email)
        val userPass = findViewById<EditText>(R.id.user_pass)
        val buttonReg = findViewById<Button>(R.id.button_reg)
        val regToLink = findViewById<TextView>(R.id.reg_to_link)

        regToLink.setOnClickListener()
        {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

        buttonReg.setOnClickListener()
        {
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val pass = userPass.text.toString().trim()

            if (login.isEmpty() || email.isEmpty() || pass.isEmpty())
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            else
            {
                val user = User(login, email, pass)
                val db = DbHelper(this, null)
                db.addUser(user)
                Toast.makeText(this, "пользователь $login добавлен", Toast.LENGTH_LONG).show()

                userLogin.text.clear()
                userEmail.text.clear()
                userPass.text.clear()

            }
        }
    }
}