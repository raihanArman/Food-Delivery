package com.randev.food_delivery.ui.components.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.randev.food_delivery.R
import com.randev.food_delivery.ui.components.textfield.drawColoredShadow
import com.randev.food_delivery.ui.theme.FoodDeliveryTheme
import com.randev.food_delivery.ui.theme.GreyBorderColor
import com.randev.food_delivery.ui.theme.ShadowColor
import com.randev.food_delivery.ui.theme.Shapes
import com.randev.food_delivery.ui.theme.TextColor

/**
 * @author Raihan Arman
 * @date 27/09/22
 */

@Composable
fun SocialMediaButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    imageResource: Int,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(57.dp),
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.dp,
                    color = GreyBorderColor,
                    shape = Shapes.large
                )
                .drawColoredShadow(ShadowColor),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White
            ),
            shape = Shapes.large,
            elevation = ButtonDefaults.elevation(0.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = imageResource),
                    contentDescription = null
                )
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    text = text,
                    color = TextColor,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewSocialMediaButton() {
    FoodDeliveryTheme() {
        SocialMediaButton(onClick = {}, text = "Facebook", imageResource = R.drawable.ic_facebook)
    }
}
