package com.nataliaber.natiwali

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Economicas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_economicas)




        val bottomSheetFragment18 = BottomSheetFragment18()

        val vermasempresas = findViewById<Button>(R.id.ver8eco)
        vermasempresas.setOnClickListener{
            bottomSheetFragment18.show(supportFragmentManager, "BottomSheetDialog")
        }




        val bottomSheetFragment19 = BottomSheetFragment19()

        val vermasfinanzas = findViewById<Button>(R.id.ver9eco)
        vermasfinanzas.setOnClickListener{
            bottomSheetFragment19.show(supportFragmentManager, "BottomSheetDialog")
        }





        val bottomSheetFragment20 = BottomSheetFragment20()

        val vermasmercadeo = findViewById<Button>(R.id.ver10eco)
        vermasmercadeo.setOnClickListener{
            bottomSheetFragment20.show(supportFragmentManager, "BottomSheetDialog")
        }





        val bottomSheetFragment21 = BottomSheetFragment21()

        val vermascontaduriapublica = findViewById<Button>(R.id.ver12eco)
        vermascontaduriapublica.setOnClickListener{
            bottomSheetFragment21.show(supportFragmentManager, "BottomSheetDialog")
        }





        val bottomSheetFragment22 = BottomSheetFragment22()

        val vermaseconomia = findViewById<Button>(R.id.ver11eco)
        vermaseconomia.setOnClickListener{
            bottomSheetFragment22.show(supportFragmentManager, "BottomSheetDialog")
        }





        val atrasECO = findViewById<Button>(R.id.atraseco)
        atrasECO.setOnClickListener{
            val atrasECOlanzar = Intent(this, facultades::class.java)
            startActivity((atrasECOlanzar))
        }

        val ECOgrupos=findViewById<Button>(R.id.ECOgruposhome5)
        ECOgrupos.setOnClickListener {
            val ECOgrupolanzar = Intent(this, home::class.java)
            startActivity(ECOgrupolanzar)

        }
        val ECOfacultad=findViewById<Button>(R.id.ECOfacultadhome5)
        ECOfacultad.setOnClickListener {
            val ECOfacultadlanzar = Intent(this, facultades::class.java)
            startActivity(ECOfacultadlanzar)

        }
    }
}