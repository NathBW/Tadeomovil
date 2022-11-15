package com.nataliaber.natiwali

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Sociales : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sociales)

        val bottomSheetFragment = BottomSheetFragment()

        val vermasHisto = findViewById<Button>(R.id.sociver15)
        vermasHisto.setOnClickListener{
            bottomSheetFragment.show(supportFragmentManager, "BottomSheetDialog")
        }


        val bottomSheetFragment2 = BottomSheetFragment2()

        val vermasCine = findViewById<Button>(R.id.ver18)
        vermasCine.setOnClickListener{
            bottomSheetFragment2.show(supportFragmentManager, "BottomSheetDialog")
        }


        val bottomSheetFragment3 = BottomSheetFragment3()

        val vermasderecho = findViewById<Button>(R.id.ver20)
        vermasderecho.setOnClickListener{
            bottomSheetFragment3.show(supportFragmentManager, "BottomSheetDialog")
        }


        val bottomSheetFragment4 = BottomSheetFragment4()

        val vermascomunicacion = findViewById<Button>(R.id.ver21)
        vermascomunicacion.setOnClickListener{
            bottomSheetFragment4.show(supportFragmentManager, "BottomSheetDialog")
        }



        val bottomSheetFragment5 = BottomSheetFragment5()

        val vermasrelacionesinternacionales = findViewById<Button>(R.id.ver22)
        vermasrelacionesinternacionales.setOnClickListener{
            bottomSheetFragment5.show(supportFragmentManager, "BottomSheetDialog")
        }


        val bottomSheetFragment6 = BottomSheetFragment6()

        val vermasliterarios = findViewById<Button>(R.id.ver23)
        vermasliterarios.setOnClickListener{
            bottomSheetFragment6.show(supportFragmentManager, "BottomSheetDialog")
        }





        val atrasSOCI = findViewById<Button>(R.id.atrassoci)
        atrasSOCI.setOnClickListener{
            val atrasSOCIlanzar = Intent(this, facultades::class.java)
            startActivity((atrasSOCIlanzar))
        }

        val SOCIgrupos=findViewById<Button>(R.id.SOCIgruposhome3)
        SOCIgrupos.setOnClickListener {
            val SOCIgrupolanzar = Intent(this, home::class.java)
            startActivity(SOCIgrupolanzar)

        }
        val SOCIfacultad=findViewById<Button>(R.id.SOCIfacultadhome3)
        SOCIfacultad.setOnClickListener {
            val SOCIfacultadlanzar = Intent(this, facultades::class.java)
            startActivity(SOCIfacultadlanzar)

        }
    }
}