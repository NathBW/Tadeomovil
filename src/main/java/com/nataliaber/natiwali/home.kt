package com.nataliaber.natiwali

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.nataliaber.natiwali.databinding.ActivityHomeBinding
import com.nataliaber.natiwali.databinding.ActivitySuscribirseBinding

class home : AppCompatActivity() {

    private lateinit var db : FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_home)
        setContentView(binding.root)
        db = Firebase.firestore





        val facultad=findViewById<Button>(R.id.facultadhome)
        facultad.setOnClickListener{
            val facultadlanzar = Intent(this, facultades::class.java)
            startActivity(facultadlanzar)
        }


        val grupis=findViewById<Button>(R.id.gruposhome)
        grupis.setOnClickListener{
            val grupislanzar = Intent(this, grupos::class.java)
            startActivity(grupislanzar)
        }
    }
}