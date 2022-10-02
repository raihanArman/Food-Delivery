package com.randev.food_delivery.ui.components.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import com.randev.food_delivery.ui.theme.PrimaryColor
import com.randev.food_delivery.ui.theme.PrimaryColorGradient
import com.randev.food_delivery.ui.theme.TextColor
import com.randev.food_delivery.util.textBrush

/**
 * @author Raihan Arman
 * @date 02/10/22
 */

@Composable
fun TextGradient(
    modifier: Modifier = Modifier,
    text: String,
    textSize: TextUnit,
    textAlign: TextAlign = TextAlign.Start
) {
    val gradient =
        Brush.horizontalGradient(listOf(PrimaryColorGradient, PrimaryColor))

    Text(
        modifier = modifier
            .textBrush(gradient),
        text = text,
        fontWeight = FontWeight.Bold,
        fontSize = textSize,
        color = TextColor,
        textAlign = textAlign
    )
}