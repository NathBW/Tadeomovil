package com.nataliaber.natiwali

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Artes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artes)


        val bottomSheetFragment7 = BottomSheetFragment7()

        val vermasarquitectura = findViewById<Button>(R.id.ver11)
        vermasarquitectura.setOnClickListener{
            bottomSheetFragment7.show(supportFragmentManager, "BottomSheetDialog")
        }


        val bottomSheetFragment8 = BottomSheetFragment8()

        val vermasartesplasticas = findViewById<Button>(R.id.ver13)
        vermasartesplasticas.setOnClickListener{
            bottomSheetFragment8.show(supportFragmentManager, "BottomSheetDialog")
        }



        val bottomSheetFragment9 = BottomSheetFragment9()

        val vermasdiseñointeractivo = findViewById<Button>(R.id.ver14)
        vermasdiseñointeractivo.setOnClickListener{
            bottomSheetFragment9.show(supportFragmentManager, "BottomSheetDialog")
        }



        val bottomSheetFragment10 = BottomSheetFragment10()

        val vermasdiseñografico = findViewById<Button>(R.id.ver16)
        vermasdiseñografico.setOnClickListener{
            bottomSheetFragment10.show(supportFragmentManager, "BottomSheetDialog")
        }


        val bottomSheetFragment11 = BottomSheetFragment11()

        val vermasdiseñoindustrial = findViewById<Button>(R.id.ver17)
        vermasdiseñoindustrial.setOnClickListener{
            bottomSheetFragment11.show(supportFragmentManager, "BottomSheetDialog")
        }



        val bottomSheetFragment12 = BottomSheetFragment12()

        val vermasestudiosliterarios = findViewById<Button>(R.id.ver15)
        vermasestudiosliterarios.setOnClickListener{
            bottomSheetFragment12.show(supportFragmentManager, "BottomSheetDialog")
        }




        val atrasART = findViewById<Button>(R.id.atrasart)
        atrasART.setOnClickListener{
            val atrasARTlanzar = Intent(this, facultades::class.java)
            startActivity((atrasARTlanzar))
        }

        val ARTgrupos=findViewById<Button>(R.id.ARTgruposhome4)
        ARTgrupos.setOnClickListener {
            val ARTgrupolanzar = Intent(this, home::class.java)
            startActivity(ARTgrupolanzar)

        }
        val ARTfacultad=findViewById<Button>(R.id.ARTfacultadhome4)
        ARTfacultad.setOnClickListener {
            val ARTfacultadlanzar = Intent(this, facultades::class.java)
            startActivity(ARTfacultadlanzar)

        }
    }
}