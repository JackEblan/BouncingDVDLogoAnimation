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
import java.util.Random

class MainActivity : ComponentActivity() {
    private val imageUtil by lazy {
        ImageUtil(applicationContext)
    }
    private val random by lazy {
        Random()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BouncingDVDTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    val configuration = LocalConfiguration.current
                    val screenWidth =
                        with(LocalDensity.current) { configuration.screenWidthDp.dp.toPx() }
                    val screenHeight =
                        with(LocalDensity.current) { configuration.screenHeightDp.dp.toPx() }

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
                                    Color(
                                        red = random.nextInt(255),
                                        green = random.nextInt(255),
                                        blue = random.nextInt(255)
                                    )
                                })
                }
            }
        }
    }
}