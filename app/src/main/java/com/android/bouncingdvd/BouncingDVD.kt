package com.android.bouncingdvd

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap

@Composable
fun BouncingDVD(
    modifier: Modifier,
    screenWidth: Float,
    screenHeight: Float,
    logo: ImageBitmap,
    logoWidth: Float,
    logoHeight: Float,
    randomColor: () -> Color
) {
    var x by remember { mutableStateOf(0f) }
    var y by remember { mutableStateOf(0f) }

    var xSpeed by remember { mutableStateOf(5f) }
    var ySpeed by remember { mutableStateOf(5f) }

    var color by remember { mutableStateOf(Color.Yellow) }

    LaunchedEffect(key1 = x, key2 = y) {
        x += xSpeed
        y += ySpeed

        if (x + logoWidth > screenWidth || x == 0f) {
            xSpeed = -xSpeed
            color = randomColor.invoke()
        }

        if (y + logoHeight / 2 > screenHeight || y == 0f) {
            ySpeed = -ySpeed
            color = randomColor.invoke()
        }
    }

    Canvas(
        modifier = modifier
    ) {
        drawImage(
            image = logo, topLeft = Offset(x, y), colorFilter = ColorFilter.tint(color = color)
        )
    }
}