package com.nataliaber.natiwali

import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.firebase.ui.storage.images.FirebaseImageLoader
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.core.Context
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import com.nataliaber.natiwali.grupos.Companion.IMAGE_REQUEST_CODE
import java.io.File
import java.io.InputStream
import java.io.OutputStream


class grupos : AppCompatActivity() {

    private val REQUEST_GALLERY = 1002
    private lateinit var button: Button
    private lateinit var imageView: ImageView
    companion object {
        val IMAGE_REQUEST_CODE = 100
    }

    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_grupos)
        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser
        var database = FirebaseDatabase.getInstance().reference




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
            val camaralanzar3 = Intent(this, com.nataliaber.natiwali.camara1::class.java)
            startActivity(camaralanzar3)
        }
        //readFireStoreData()


        var getdata = object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(p0: DataSnapshot) {
                var sb = StringBuilder ()
                for (i in p0.children) {
                    var empno1 = i.child("empno").getValue()
                    sb.append("${i.key} $empno1 \n")
                }
                val textviewww = findViewById<TextView>(R.id.textViewResultdata)
                textviewww.setText(sb)
            }
        }
        database.addValueEventListener(getdata)
        database.addListenerForSingleValueEvent(getdata)

        if (user !=null){
            Toast.makeText(baseContext,  "Mira comentarios " + user.email, Toast.LENGTH_LONG).show()
        }


        val casss = findViewById<Button>(R.id.ccc)
        casss.setOnClickListener{

            val intent1 = Intent(MediaStore.ACTION_IMAGE_CAPTURE).also {
                it.resolveActivity(packageManager)
            }

            camara1.launch(intent1)

        }


        button = findViewById(R.id.Galeria)
        imageView = findViewById(R.id.imagen1)

        button.setOnClickListener{
            pickImageGallery()

        }
    }

    private fun pickImageGallery() {
        val inttt = Intent(Intent.ACTION_PICK)
        inttt.type = "image/*"
        startActivityForResult(inttt, IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK){
            imageView.setImageURI(data?.data)
        }
    }

    fun loadWithGlide() {
        // [START storage_load_with_glide]
        // Reference to an image file in Cloud Storage
        val storageReference = Firebase.storage.reference

        // ImageView in your Activity
        val imageView = findViewById<ImageView>(R.id.imagen1)

        // Download directly from StorageReference using Glide
        // (See MyAppGlideModule for Loader registration)
        Glide.with(this, )
            .load(storageReference)
            .into(imageView)
        // [END storage_load_with_glide]






    }

    //fun readFireStoreData() {
    //    val db = FirebaseFirestore.getInstance()
    //    db.collection("photos")
    //        .get()
    //        .addOnCompleteListener{
    //            val result: StringBuffer = StringBuffer()

    //            if(it.isSuccessful) {
    //                for (document in it.result!!) {
    //                    result.append(document.data.getValue("input")).append("")
    //                }
    //                val extipu=findViewById<TextView>(R.id.textViewResultgrup).setText(result)
    //            }

    //        }
    //}

    val camara1 = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if(result.resultCode == RESULT_OK){
            val data = result.data!!
            val bitmap1 = data.extras!!.get("data") as Bitmap
            //val bitmap1 = getBitmap1()
            val issss = findViewById<ImageView>(R.id.imagen1)
            issss.setImageBitmap(bitmap1)
            //binding.imagen.setImageBitmap(bitmap)
            //binding.imagen.setImageBitmap(bitmap)
        }
    }


}