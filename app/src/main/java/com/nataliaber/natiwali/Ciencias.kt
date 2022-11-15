package com.nataliaber.natiwali

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Ciencias : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciencias)




        val bottomSheetFragment13 = BottomSheetFragment13()

        val vermasmodelado = findViewById<Button>(R.id.ver3)
        vermasmodelado.setOnClickListener{
            bottomSheetFragment13.show(supportFragmentManager, "BottomSheetDialog")
        }




        val bottomSheetFragment14 = BottomSheetFragment14()

        val vermasbiologiamarina = findViewById<Button>(R.id.ver)
        vermasbiologiamarina.setOnClickListener{
            bottomSheetFragment14.show(supportFragmentManager, "BottomSheetDialog")
        }




        val bottomSheetFragment15 = BottomSheetFragment15()

        val vermasindustrial = findViewById<Button>(R.id.ver2)
        vermasindustrial.setOnClickListener{
            bottomSheetFragment15.show(supportFragmentManager, "BottomSheetDialog")
        }



        val bottomSheetFragment16 = BottomSheetFragment16()

        val vermassistemas = findViewById<Button>(R.id.ver7)
        vermassistemas.setOnClickListener{
            bottomSheetFragment16.show(supportFragmentManager, "BottomSheetDialog")
        }



        val bottomSheetFragment17 = BottomSheetFragment17()

        val vermasambiental = findViewById<Button>(R.id.ver8)
        vermasambiental.setOnClickListener{
            bottomSheetFragment17.show(supportFragmentManager, "BottomSheetDialog")
        }





        val atrasCIE = findViewById<Button>(R.id.atrascien)
        atrasCIE.setOnClickListener{
            val atrasCIElanzar = Intent(this, facultades::class.java)
            startActivity((atrasCIElanzar))
        }

        val CIEgrupos=findViewById<Button>(R.id.CIEgruposhome2)
        CIEgrupos.setOnClickListener {
            val CIEgrupolanzar = Intent(this, home::class.java)
            startActivity(CIEgrupolanzar)

        }
        val CIEfacultad=findViewById<Button>(R.id.CIEfacultadhome2)
        CIEfacultad.setOnClickListener {
            val CIEfacultadlanzar = Intent(this, facultades::class.java)
            startActivity(CIEfacultadlanzar)

        }
    }
}