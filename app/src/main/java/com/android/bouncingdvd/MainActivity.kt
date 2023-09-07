package com.android.bouncingdvd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.android.bouncingdvd.ui.theme.BouncingDVDTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.Random
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var imageUtil: ImageUtil

    @Inject
    lateinit var resourceUtil: ResourceUtil

    @Inject
    lateinit var random: Random

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BouncingDVDTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    BouncingDVD(modifier = Modifier.fillMaxSize(),
                                imageUtil = imageUtil,
                                resourceUtil = resourceUtil,
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