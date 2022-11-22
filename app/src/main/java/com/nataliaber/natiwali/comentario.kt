package com.nataliaber.natiwali

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.BitmapRegionDecoder
import android.graphics.Picture
import android.media.Image
import android.net.Uri
import android.widget.ImageView
import androidx.core.graphics.createBitmap
import androidx.core.graphics.drawable.toDrawable
import androidx.core.net.toUri
import java.io.File
import java.net.URI
import java.util.*

class comentario {
    var empno = ""
    constructor(empno: String) {
        this.empno = empno
    }
}