package com.nataliaber.natiwali
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View.inflate
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.nataliaber.natiwali.databinding.ActivitySuscribirseBinding
import androidx.appcompat.resources.Compatibility.Api21Impl.inflate
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.core.graphics.drawable.DrawableCompat.inflate
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.firestore.AggregateSource
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FieldPath
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.google.firebase.firestore.MetadataChanges
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ServerTimestamp
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.Source
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.firestoreSettings
import com.google.firebase.firestore.ktx.toObject



class suscribirse : AppCompatActivity() {


    private lateinit var db : FirebaseFirestore
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySuscribirseBinding.inflate(layoutInflater)

        setContentView(binding.root)
        auth = Firebase.auth
        db = Firebase.firestore

        val textEmail : TextView = binding.correo2
        val textPassword : TextView = binding.contraseA2

        binding.iniciar2.setOnClickListener{
            creatCount(textEmail.text.toString(), textPassword.text.toString())
            val settings = firestoreSettings {
                isPersistenceEnabled = true
            }
            db.firestoreSettings = settings
            // [END set_firestore_settings]
            val db = Firebase.firestore
            val settingsf = firestoreSettings {
                cacheSizeBytes = FirebaseFirestoreSettings.CACHE_SIZE_UNLIMITED
            }
            db.firestoreSettings = settingsf
            // [END fs_setup_cache]
        }
        }
    private fun creatCount (email : String, password : String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {  Task ->
                if (Task.isSuccessful) {
                    Toast.makeText(baseContext, "Cuenta Creada", Toast.LENGTH_SHORT).show()


                    fun addAdaLovelace() {
                        // [START add_ada_lovelace]
                        // Create a new user with a first and last name
                        val user = hashMapOf(
                            "email" to auth.currentUser,
                            "emailVerafied" to true,
                            "iud" to auth.uid,
                            "admin" to false
                        )
                        // Add a new document with a generated ID
                        db.collection("users")
                            .add(user)
                            .addOnSuccessListener { documentReference ->
                                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                            }
                            .addOnFailureListener { e ->
                                Log.w(TAG, "Error adding document", e)
                            }
                        // [END add_ada_lovelace]
                    }

                    val suslanzar = Intent(this, home::class.java)
                    startActivity(suslanzar)


                }else{
                    Toast.makeText(baseContext, "Algo Salió mal" + Task.exception, Toast.LENGTH_SHORT).show()

                }
            }
    }
}



