package com.randev.food_delivery.ui.components.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.randev.food_delivery.R
import com.randev.food_delivery.ui.theme.FoodDeliveryTheme
import com.randev.food_delivery.ui.theme.Shapes
import com.randev.food_delivery.ui.theme.ThirdColor

/**
 * @author Raihan Arman
 * @date 02/10/22
 */

@Composable
fun BackButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .size(45.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = ThirdColor.copy(alpha = 0.1f)
        ),
        shape = Shapes.large,
        elevation = ButtonDefaults.elevation(0.dp),
        contentPadding = PaddingValues(0.dp)
    ) {
        Icon(
            modifier = Modifier
                .size(16.dp),
            painter = painterResource(id = R.drawable.ic_baseline_arrow_back_ios_new_24),
            contentDescription = null,
            tint = ThirdColor
        )
    }
}

@Preview
@Composable
fun PreviewBackButton() {
    FoodDeliveryTheme {
        BackButton(
            onClick = {}
        )
    }
}