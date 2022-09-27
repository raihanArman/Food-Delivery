package com.randev.food_delivery.ui.components.button

import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.randev.food_delivery.ui.theme.FoodDeliveryTheme
import com.randev.food_delivery.ui.theme.PrimaryColor
import com.randev.food_delivery.ui.theme.TextColor

/**
 * @author Raihan Arman
 * @date 27/09/22
 */

@Composable
fun TextButtonCustom(
    text: String,
    textColor: Color = PrimaryColor,
    onClick: () -> Unit,
) {
    TextButton(
        onClick = onClick
    ){
        Text(
            text = text,
            color = textColor,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview
@Composable
fun PreviewTextButtonCustom() {
    FoodDeliveryTheme() {
        TextButtonCustom(text = "Forgot Password ?", textColor = PrimaryColor) {

        }
    }
}