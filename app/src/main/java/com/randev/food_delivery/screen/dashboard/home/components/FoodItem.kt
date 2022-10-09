package com.randev.food_delivery.screen.dashboard.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.food_delivery.data.Food
import com.randev.food_delivery.data.getFoodList
import com.randev.food_delivery.ui.components.space.HorizontalSpace
import com.randev.food_delivery.ui.components.space.VerticalSpace
import com.randev.food_delivery.ui.components.text.TextBold
import com.randev.food_delivery.ui.components.text.TextDescription
import com.randev.food_delivery.ui.theme.FoodDeliveryTheme
import com.randev.food_delivery.ui.theme.ShadowColor
import com.randev.food_delivery.ui.theme.Shapes
import com.randev.food_delivery.ui.theme.ThirdColor
import com.randev.food_delivery.util.drawColoredShadow

/**
 * @author Raihan Arman
 * @date 07/10/22
 */

@Composable
fun FoodItem(
    food: Food
) {
    Card(
        modifier = Modifier
            .padding(bottom = 20.dp)
            .fillMaxWidth()
            .height(87.dp)
            .drawColoredShadow(ShadowColor),
        shape = Shapes.large,
        backgroundColor = Color.White,
        elevation = 0.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Card(
                modifier = Modifier
                    .size(64.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Image(
                    painter = painterResource(id = food.image),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            HorizontalSpace(width = 20.dp)
            Column(
                modifier = Modifier
                    .weight(1f),
                horizontalAlignment = Alignment.Start
            ) {
                TextBold(text = food.title, textSize = 15.sp)
                VerticalSpace(height = 4.dp)
                TextDescription(text = food.description, textSize = 14.sp)
            }
            Text(
                text = food.price,
                fontWeight = FontWeight.Bold,
                color = ThirdColor,
                fontSize = 22.sp
            )
        }
    }
}

@Preview
@Composable
fun PreviewFoodItem() {
    FoodDeliveryTheme {
        FoodItem(getFoodList()[0])
    }
}