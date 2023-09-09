package com.android.bouncingdvd

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap

class ImageUtil(private val context: Context) {

    fun resizeImageBitmap(@DrawableRes id: Int, width: Float, height: Float): ImageBitmap {
        val image = BitmapFactory.decodeResource(context.resources, id)
        val oldWidth = image.width.toFloat()
        val oldHeight = image.height.toFloat()

        var newWidth = width
        var newHeight = height

        val oldRatio = oldWidth / oldHeight
        val newRatio = width / height

        if (newRatio > oldRatio) {
            newWidth = (height * oldRatio)
        } else {
            newHeight = (width / oldRatio)
        }

        return Bitmap.createScaledBitmap(
            image, newWidth.toInt(), newHeight.toInt(), true
        ).asImageBitmap()
    }
}