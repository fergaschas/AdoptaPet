package com.fgascon.adoptapet.splash.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onFinish: () -> Unit
) {
    val gradiantBackground = Brush.horizontalGradient(
        0.0f to Color(red = 237, green = 118, blue = 94),
        1.0f to Color(red = 254, green = 168, blue = 88),
        startX = 0.0f,
        endX = 1000.0f
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradiantBackground),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "AdoptaPet",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        HorizontalDivider(
            thickness = 0.dp,
            modifier = Modifier.size(16.dp)
        )
        Icon(
            imageVector = Icons.Default.Pets,
            contentDescription = null,
            modifier = Modifier.size(72.dp),
            tint = Color.White
        )
    }
    LaunchedEffect(Unit) {
        delay(200)
        onFinish()
    }
}
