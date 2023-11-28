package com.sergey.registrationpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val userLogin = findViewById<EditText>(R.id.user_login_auth)
        val userPass = findViewById<EditText>(R.id.user_pass_auth)
        val buttonLink = findViewById<Button>(R.id.button_auth)

        val linkToReg = findViewById<TextView>(R.id.link_to_reg)

        linkToReg.setOnClickListener()
        {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        buttonLink.setOnClickListener()
        {
            val login = userLogin.text.toString().trim()
            val pass = userPass.text.toString().trim()

            if (login.isEmpty() || pass.isEmpty())
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            else
            {
                val db = DbHelper(this, null)
                val isAuth = db.getUser(login, pass)

                if (isAuth)
                {
                    Toast.makeText(this, "пользователь $login авторизован", Toast.LENGTH_LONG).show()
                    userLogin.text.clear()
                    userPass.text.clear()
                }
                else
                    Toast.makeText(this, "пользователь не $login авторизован", Toast.LENGTH_LONG).show()

                userLogin.text.clear()
                userPass.text.clear()

            }
        }
    }
}