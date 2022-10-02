package com.randev.food_delivery.ui.components.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.food_delivery.ui.components.text.TextBold
import com.randev.food_delivery.ui.theme.GreyBorderColor
import com.randev.food_delivery.ui.theme.GreyButtonColor
import com.randev.food_delivery.ui.theme.Shapes

/**
 * @author Raihan Arman
 * @date 02/10/22
 */

@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    backgroundColor: Color = GreyButtonColor
) {
    Button(
        modifier = modifier
            .height(57.dp)
            .fillMaxWidth(),
        onClick = onClick,
        shape = Shapes.large,
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
        elevation = ButtonDefaults.elevation(0.dp)
    ) {
        TextBold(text = text, textSize = 14.sp)
    }
}