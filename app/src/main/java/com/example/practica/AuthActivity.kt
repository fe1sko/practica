package com.example.practica

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

        val userLogin: EditText = findViewById(R.id.login)
        val userPass: EditText = findViewById(R.id.pass)
        val button: Button = findViewById(R.id.button_reg)
        val linkToReg: TextView = findViewById(R.id.link_to_reg)
        linkToReg.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val pass = userPass.text.toString().trim()

            if (login == "" || pass == "")
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            else {
                val db = DbHelper(this,null)
              val isauth = db.getUser(login,pass)
                if(isauth){
                    Toast.makeText(this, "Пользователь $login добавлен", Toast.LENGTH_LONG).show()
                } else
                    Toast.makeText(this, "Пользователь $login не авторизован", Toast.LENGTH_LONG).show()


            }
        }
    }
}