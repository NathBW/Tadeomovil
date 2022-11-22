package com.nataliaber.natiwali

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.nataliaber.natiwali.databinding.ActivityHomeBinding
import com.nataliaber.natiwali.databinding.ActivitySuscribirseBinding

class home : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_home)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        auth = Firebase.auth
        val user = auth.currentUser
        if (user !=null){
            Toast.makeText(baseContext, "Bienvenido " + user.email , Toast.LENGTH_SHORT).show()
        }


        binding.logout.setOnClickListener{
            logOut().also {
                val logoutlanzar = Intent(this, MainActivity::class.java)
                startActivity(logoutlanzar)

            }
        }


        val facultad=findViewById<Button>(R.id.facultadhome)
        facultad.setOnClickListener{
            val facultadlanzar = Intent(this, facultades::class.java)
            startActivity(facultadlanzar)
        }


        val homegrupis=findViewById<Button>(R.id.gruposhome)
        homegrupis.setOnClickListener{
            val homegrupislanzar = Intent(this, home::class.java)
            startActivity(homegrupislanzar)
        }

        val grupis=findViewById<Button>(R.id.textViewResult)
        grupis.setOnClickListener{
            val grupislanzar = Intent(this, grupos::class.java)
            startActivity(grupislanzar)
        }

        readFireStoreData()
    }



    fun readFireStoreData() {
        val db = FirebaseFirestore.getInstance()
        db.collection("guides")
            .get()
            .addOnCompleteListener{
                val result: StringBuffer = StringBuffer()

                if(it.isSuccessful) {
                    for (document in it.result!!) {
                        result.append(document.data.getValue("title")).append(":  ")
                            .append(document.data.getValue("content")).append("\n\n")
                    }
                    val exti=findViewById<Button>(R.id.textViewResult).setText(result)
                }

            }
    }


    private fun logOut () {
        auth.signOut().also {
            Toast.makeText(baseContext, "Saliste" , Toast.LENGTH_SHORT).show()
        }

    }

}