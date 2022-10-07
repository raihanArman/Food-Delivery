package com.randev.food_delivery.screen.dashboard.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.randev.food_delivery.ui.components.text.TextBold
import com.randev.food_delivery.ui.theme.ThirdColor

/**
 * @author Raihan Arman
 * @date 07/10/22
 */

@Composable
fun TitleItemFood(
    modifier: Modifier = Modifier,
    title: String,
    onClickMore: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextBold(text = title, textSize = 15.sp)
        Text(
            modifier = Modifier
                .clickable {
                    onClickMore()
                },
            text = "View More",
            fontWeight = FontWeight.Light,
            color = ThirdColor
        )
    }
}