package com.nataliaber.natiwali

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class grupos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grupos)


        val facultad3=findViewById<Button>(R.id.facultades3)
        facultad3.setOnClickListener {
            val faculanzar3 = Intent(this, facultades::class.java)
            startActivity(faculanzar3)
        }

        val grupos3=findViewById<Button>(R.id.grupos3)
        grupos3.setOnClickListener {
            val grupolanzar3 = Intent(this, home::class.java)
            startActivity(grupolanzar3)

        }


        val camara=findViewById<Button>(R.id.publicar)
        camara.setOnClickListener {
            val camaralanzar3 = Intent(this, camara1::class.java)
            startActivity(camaralanzar3)

        }

    }


}