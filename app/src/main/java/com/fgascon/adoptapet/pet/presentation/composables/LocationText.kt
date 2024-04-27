package com.fgascon.adoptapet.pet.presentation.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.FlowPreview


@OptIn(FlowPreview::class)
@Composable
fun LocationText(
    city: String,
    country: String,
    onClick: () -> Unit = {},
) {

    Column(
        modifier = Modifier.clickable {
            onClick()
        }
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
        ) {
            Icon(
                imageVector = Icons.Outlined.LocationOn,
                contentDescription = "Home",
                tint = Color.Gray,
            )
            Text(
                text = "Location",
                fontSize = 14.sp,
                fontWeight = FontWeight(600),
                color = Color.Gray,
            )
        }
        Text(
            text = "$city, $country",
            fontSize = 16.sp,
        )
    }
}
