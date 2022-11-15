package com.nataliaber.natiwali

import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.FirebaseFirestore
import java.io.File
import java.io.OutputStream

class grupos : AppCompatActivity() {

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
            val camaralanzar3 = Intent(this, camara1::class.java)
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


    private lateinit var file: File
    private fun createPhotoFile() {
        val dir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)!!
        file = File.createTempFile("IMG_${System.currentTimeMillis()}_", ".jpg", dir)
    }

    private fun save(content: ContentValues): Uri {
        var outputStream: OutputStream?
        var uri: Uri?
        application.contentResolver.also { resolver ->
            uri = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, content)
            outputStream = resolver.openOutputStream(uri!!)
        }
        outputStream.use { output ->
            getBitmap().compress(Bitmap.CompressFormat.JPEG, 100, output)
        }
        return uri!!
    }
    private fun getBitmap(): Bitmap {
        return BitmapFactory.decodeFile(file.toString())
    }

}