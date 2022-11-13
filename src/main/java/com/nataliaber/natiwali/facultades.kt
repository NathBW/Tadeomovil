package com.nataliaber.natiwali

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class facultades : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facultades)


        val grupos=findViewById<Button>(R.id.grupos2)
        grupos.setOnClickListener {
            val grupolanzar = Intent(this, home::class.java)
            startActivity(grupolanzar)

        }
    }
}