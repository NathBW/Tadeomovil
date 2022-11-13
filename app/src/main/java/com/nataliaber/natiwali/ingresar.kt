package com.nataliaber.natiwali

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import com.nataliaber.natiwali.databinding.ActivityIngresarBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ingresar : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private  lateinit var authStateListener : FirebaseAuth.AuthStateListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityIngresarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth
        val textEmail : TextView = binding.correo
        val txtPassword : TextView = binding.contraseA
        binding.iniciar.setOnClickListener{
            signIn(textEmail.text.toString(), txtPassword.text.toString())
        }
    }
    private fun signIn (email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){ task ->
                if (task.isSuccessful) {
                    Toast.makeText(baseContext, "Autenticación Exitosa" , Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, home::class.java)
                    startActivity(intent)
                }
                else {
                    Toast.makeText(baseContext, "Error de Email y/o Contraseña" , Toast.LENGTH_SHORT).show()
                }
            }
    }

}