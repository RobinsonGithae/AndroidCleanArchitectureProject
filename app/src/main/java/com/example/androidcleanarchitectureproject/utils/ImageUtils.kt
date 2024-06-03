package com.example.androidcleanarchitectureproject.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.provider.MediaStore
import android.util.Base64
import java.io.ByteArrayOutputStream
import java.io.File


object ImageUtils {
    @Throws(IllegalArgumentException::class)
    fun decodeBase64(base64Str: String): Bitmap {
        val decodedBytes = Base64.decode(
            base64Str.substring(base64Str.indexOf(",") + 1),
            Base64.NO_WRAP
        )
        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
    }

    fun encodeToBytes(bitmap: Bitmap): ByteArray {
        return try {
            val byteArrayOutputStream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
            byteArrayOutputStream.toByteArray()
        } catch (outOfMemoryError: OutOfMemoryError) {
            val byteArrayOutputStream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 50, byteArrayOutputStream)
            byteArrayOutputStream.toByteArray()
        }
    }

    fun generateImageDir(appName: String, context: Context): File? {
        val path = File(context.filesDir, appName + File.separator + "Images")
        return if (!path.exists()) {
            if (path.mkdirs()) {
                path
            } else {
                null
            }
        } else path
    }

    fun encodeTobase64(bitmap: Bitmap): String {
        return try {
            val byteArrayOutputStream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
            val b = byteArrayOutputStream.toByteArray()
            Base64.encodeToString(b, Base64.NO_WRAP)
        } catch (outOfMemoryError: OutOfMemoryError) {
            val byteArrayOutputStream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 50, byteArrayOutputStream)
            val b = byteArrayOutputStream.toByteArray()
            Base64.encodeToString(b, Base64.NO_WRAP)
        }
    }

    fun chooseSinglePhoto(activity: Activity, code: Int) {
        val gallery_intent = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )
        activity.startActivityForResult(gallery_intent, code)
    }

    fun chooseMultiplePhoto(activity: Activity, code: Int) {
        val gallery_intent = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )
        activity.startActivityForResult(gallery_intent, code)
    }
}

