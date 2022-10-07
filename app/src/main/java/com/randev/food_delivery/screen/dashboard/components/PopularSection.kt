package com.randev.food_delivery.screen.dashboard.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.randev.food_delivery.data.Food
import com.randev.food_delivery.ui.components.space.VerticalSpace

/**
 * @author Raihan Arman
 * @date 07/10/22
 */

@Composable
fun PopularSection(
    modifier: Modifier = Modifier,
    foods: List<Food>
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        TitleItemFood(title = "Popular Menu") {
            
        }
        VerticalSpace(height = 20.dp)
        foods.forEach { food ->
            FoodItem(food = food)
        }
    }
}

@Preview
@Composable
fun PreviewPopularSection() {

}