package com.nataliaber.natiwali

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val Crear=findViewById<Button>(R.id.crear)
        Crear.setOnClickListener{
            val crearlanzar = Intent(this, com.nataliaber.natiwali.home::class.java)
            startActivity(crearlanzar)
        }
    }
}