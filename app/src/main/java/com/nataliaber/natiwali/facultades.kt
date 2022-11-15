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

        val vernat = findViewById<Button>(R.id.ver3)
        vernat.setOnClickListener{
            val naturlanzar = Intent(this, Ciencias::class.java)
            startActivity((naturlanzar))
        }

        val versoci = findViewById<Button>(R.id.ver4)
        versoci.setOnClickListener{
            val socilanzar = Intent(this, Sociales::class.java)
            startActivity((socilanzar))
        }


        val verearte = findViewById<Button>(R.id.ver5)
        verearte.setOnClickListener{
            val  artelanzar = Intent(this, Artes::class.java)
            startActivity((artelanzar))
        }


        val  vereconomi = findViewById<Button>(R.id.ver6)
        vereconomi.setOnClickListener{
            val   economilanzar= Intent(this, Economicas::class.java)
            startActivity(( economilanzar))
        }
    }
}