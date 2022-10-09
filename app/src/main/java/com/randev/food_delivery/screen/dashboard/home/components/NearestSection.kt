package com.randev.food_delivery.screen.dashboard.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.randev.food_delivery.data.Restaurant
import com.randev.food_delivery.ui.components.space.VerticalSpace

/**
 * @author Raihan Arman
 * @date 07/10/22
 */

@Composable
fun NearestSection(
    modifier: Modifier = Modifier,
    restaurants: List<Restaurant>
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        TitleItemFood(title = "Nearest Restaurant") {

        }
        VerticalSpace(height = 20.dp)
        LazyRow {
            items(restaurants) { index ->
                RestaurantItem(restaurant = index)
            }
        }
    }
}