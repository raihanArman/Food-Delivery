package com.randev.food_delivery.ui.components.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.food_delivery.ui.theme.FoodDeliveryTheme
import com.randev.food_delivery.ui.theme.PrimaryColor
import com.randev.food_delivery.ui.theme.PrimaryColorGradient
import com.randev.food_delivery.ui.theme.Shapes

/**
 * @author Raihan Arman
 * @date 27/09/22
 */

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String
) {
    val gradient =
        Brush.horizontalGradient(listOf(PrimaryColorGradient, PrimaryColor))

    Button(
        modifier = modifier
            .height(57.dp),
        shape = Shapes.large,
        onClick = onClick,
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        )
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(gradient)
                .then(modifier),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = text,
                color = Color.White,
                fontFamily = MaterialTheme.typography.h4.fontFamily,
                fontSize = 16.sp
            )
        }
    }
}

@Preview
@Composable
fun PreviewPrimaryButton() {
    FoodDeliveryTheme {
        PrimaryButton(
            text = "Next",
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}