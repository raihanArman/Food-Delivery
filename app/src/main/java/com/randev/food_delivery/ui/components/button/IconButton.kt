package com.randev.food_delivery.ui.components.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.randev.food_delivery.R
import com.randev.food_delivery.ui.theme.ShadowColor
import com.randev.food_delivery.ui.theme.Shapes
import com.randev.food_delivery.util.drawColoredShadow

/**
 * @author Raihan Arman
 * @date 07/10/22
 */

@Composable
fun IconButton(
    backgroundColor: Color ?= null,
    icon: @Composable () -> Unit,
) {
    Card(
        modifier = Modifier
            .size(45.dp)
            .drawColoredShadow(ShadowColor),
        shape = Shapes.large,
        elevation = 0.dp
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor ?: Color.White)
        ){
            icon()
        }
    }
}