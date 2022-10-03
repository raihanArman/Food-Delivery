package com.randev.food_delivery.ui.components.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.randev.food_delivery.ui.theme.TextColor

/**
 * @author Raihan Arman
 * @date 27/09/22
 */

@Composable
fun TextDescription(
    modifier: Modifier = Modifier,
    text: String,
    textSize: TextUnit,
    textColor: Color = TextColor,
    textAlign: TextAlign = TextAlign.Start,
    fontWeight: FontWeight = FontWeight.Light
) {
    Text(
        modifier = modifier,
        text = text,
        fontWeight = fontWeight,
        fontSize = textSize,
        color = textColor,
        textAlign = textAlign
    )
}