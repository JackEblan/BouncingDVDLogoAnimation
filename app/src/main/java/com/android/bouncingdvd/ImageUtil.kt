package com.android.bouncingdvd

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap

class ImageUtil(private val context: Context) {
    fun resizeImageBitmap(@DrawableRes id: Int, maxWidth: Int, maxHeight: Int): ImageBitmap {
        val image = BitmapFactory.decodeResource(context.resources, id)
        val sourceWidth: Int = image.width
        val sourceHeight: Int = image.height

        var targetWidth = maxWidth
        var targetHeight = maxHeight

        val sourceRatio = sourceWidth.toFloat() / sourceHeight.toFloat()
        val targetRatio = maxWidth.toFloat() / maxHeight.toFloat()

        if (targetRatio > sourceRatio) {
            targetWidth = (maxHeight.toFloat() * sourceRatio).toInt()
        } else {
            targetHeight = (maxWidth.toFloat() / sourceRatio).toInt()
        }

        return Bitmap.createScaledBitmap(
            image, targetWidth, targetHeight, true
        ).asImageBitmap()
    }
}