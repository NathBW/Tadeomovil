package com.nataliaber.natiwali

import android.app.Activity
import android.app.Instrumentation
import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.BitmapRegionDecoder
import android.icu.util.Output
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.animation.AnticipateInterpolator
import android.widget.Button
import com.nataliaber.natiwali.databinding.ActivityCamara1Binding
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
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
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.OutputStream


class camara1 : AppCompatActivity() {
    private val filer = 1
    private val database = Firebase.database
    val MyRef = database.getReference("Imagenes")
    private lateinit var imgUri: Uri
    private lateinit var auth : FirebaseAuth
    private lateinit var binding : ActivityCamara1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCamara1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser
        var database = FirebaseDatabase.getInstance().reference
        //setContentView(R.layout.activity_camara1)

        val atraspublicar = findViewById<Button>(R.id.atraspublcar)
        atraspublicar.setOnClickListener{
            val atraspublicarlanzar = Intent(this, grupos::class.java)
            startActivity((atraspublicarlanzar))
        }
        binding.Camara.setOnClickListener{

            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).also {
                it.resolveActivity(packageManager).also { component ->
                    createPhotoFile()
                    val photoUri: Uri =
                        FileProvider.getUriForFile(
                            this,
                            BuildConfig.APPLICATION_ID + ".fileprovider", file
                        )
                    it.putExtra(MediaStore.EXTRA_OUTPUT, photoUri)
                }
            }
           //camara.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
                camara.launch(intent)
        }
        //val input = findViewById<EditText>(R.id.comentarios).text.toString()
        //val input = binding.inputComentarios.text.toString()

            binding.guardar2.setOnClickListener {
                saveToGallery()
            }
        binding.publicar2.setOnClickListener{
            //saveFireStore(input).also {
                val mandarlanzar = Intent(this, grupos::class.java)
                startActivity(mandarlanzar).also {
                    var empno = binding.inputComentarios.text.toString()
                    var esal = binding.editTextTextPersonName.text.toString().toInt()

                    database.child(esal.toString()).setValue(comentario(empno))
                    Toast.makeText(this@camara1, "Comentario guardado", Toast.LENGTH_SHORT).show()
                }
           // }
        }
        //val btnCamara = findViewById<Button>(R.id.Camara)
        //binding.Camara.setOnClickListener {
        //    startForResult.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
        //}

    }

    //fun saveFireStore(input: String) {
    //    val db = FirebaseFirestore.getInstance()
    //    val coment : MutableMap<String, Any> = HashMap()
    //    coment["input"] = input

    //    db.collection("photos")
    //        .add(coment)
    //        .addOnSuccessListener {
    //            Toast.makeText(this@camara1, "Comentario guardado", Toast.LENGTH_SHORT).show()
    //        }
    //        .addOnFailureListener{
    //            Toast.makeText(this@camara1, "Comentario NO SE PUDO guardar", Toast.LENGTH_SHORT).show()
    //        }

    //}



    val camara = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if(result.resultCode == RESULT_OK){
                //val data = result.data!!
                //val bitmap = data.extras!!.get("data") as Bitmap
                val bitmap = getBitmap()
                binding.imagen.setImageBitmap(bitmap)
            }
        }

    private lateinit var file: File
    private fun createPhotoFile() {
        val dir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)!!
        file = File.createTempFile("IMG_${System.currentTimeMillis()}_", ".jpg", dir)
    }

    private fun saveToGallery() {
        val content = createContent()
        val uri = save(content)
        clearContents(content, uri)
        Toast.makeText(this, "Imagen guardada",Toast.LENGTH_LONG).show()
    }

    private fun createContent(): ContentValues {
        val fileName = file.name
        val fileType = "image/jpg"
        return ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, fileName)
            put(MediaStore.Files.FileColumns.MIME_TYPE, fileType)
            put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES)
            put(MediaStore.MediaColumns.IS_PENDING, 1)
        }
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

    private fun clearContents(content: ContentValues, uri: Uri) {
        content.clear()
        content.put(MediaStore.MediaColumns.IS_PENDING,0)
        contentResolver.update(uri,content,null,null)
    }

    private fun getBitmap(): Bitmap {
        return BitmapFactory.decodeFile(file.toString())
    }

}