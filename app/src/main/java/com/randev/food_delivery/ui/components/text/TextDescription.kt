package com.randev.food_delivery.ui.components.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        modifier = modifier,
        text = text,
        fontWeight = FontWeight.Light,
        fontSize = textSize,
        color = TextColor,
        textAlign = textAlign
    )
}