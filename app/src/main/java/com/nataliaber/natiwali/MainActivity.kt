package com.nataliaber.natiwali

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ingresar=findViewById<Button>(R.id.ingresar)
        ingresar.setOnClickListener{
            val inglanzar = Intent(this, com.nataliaber.natiwali.ingresar::class.java)
            startActivity(inglanzar)
        }

        val suscribirse=findViewById<Button>(R.id.suscribirse)
        suscribirse.setOnClickListener{
            val suslanzar = Intent(this, com.nataliaber.natiwali.suscribirse::class.java)
            startActivity(suslanzar)
        }
    }
}