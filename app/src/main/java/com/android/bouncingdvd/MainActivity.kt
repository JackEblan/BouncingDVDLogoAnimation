package com.android.bouncingdvd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.android.bouncingdvd.ui.theme.BouncingDVDTheme

class MainActivity : ComponentActivity() {
    private val imageUtil by lazy {
        ImageUtil(applicationContext)
    }

    private val colors = listOf(Color.Red, Color.Green, Color.Blue)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BouncingDVDTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    val screenWidth =
                        with(LocalDensity.current) { LocalConfiguration.current.screenWidthDp.dp.toPx() }
                    val screenHeight =
                        with(LocalDensity.current) { LocalConfiguration.current.screenHeightDp.dp.toPx() }

                    val logoWidth = with(LocalDensity.current) { 80.dp.toPx() }
                    val logoHeight = with(LocalDensity.current) { 80.dp.toPx() }

                    val logo = remember {
                        imageUtil.resizeImageBitmap(
                            id = R.drawable.dvd_logo, width = logoWidth, height = logoHeight
                        )
                    }
                    BouncingDVD(modifier = Modifier.fillMaxSize(),
                                screenWidth = screenWidth,
                                screenHeight = screenHeight,
                                logo = logo,
                                logoWidth = logoWidth,
                                logoHeight = logoHeight,
                                randomColor = {
                                    colors.random()
                                })
                }
            }
        }
    }
}