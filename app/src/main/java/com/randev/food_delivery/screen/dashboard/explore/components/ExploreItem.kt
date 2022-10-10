package com.randev.food_delivery.screen.dashboard.explore.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.food_delivery.data.Restaurant
import com.randev.food_delivery.ui.components.space.VerticalSpace
import com.randev.food_delivery.ui.components.text.TextBold
import com.randev.food_delivery.ui.components.text.TextDescription
import com.randev.food_delivery.ui.theme.ShadowColor
import com.randev.food_delivery.ui.theme.Shapes
import com.randev.food_delivery.util.drawColoredShadow

/**
 * @author Raihan Arman
 * @date 11/10/22
 */

@Composable
fun ExploreItem(
    modifier: Modifier = Modifier,
    restaurant: Restaurant
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(184.dp)
            .drawColoredShadow(ShadowColor),
        backgroundColor = Color.White,
        elevation = 0.dp,
        shape = Shapes.large
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = restaurant.image),
                contentDescription = null,
                modifier = Modifier
                    .width(96.dp)
                    .weight(1f),
            )
            VerticalSpace(height = 10.dp)
            TextBold(text = restaurant.title, textSize = 16.sp)
            VerticalSpace(height = 4.dp)
            TextDescription(text = restaurant.time, textSize = 13.sp)
        }
    }
}