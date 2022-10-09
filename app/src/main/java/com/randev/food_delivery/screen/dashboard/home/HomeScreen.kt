package com.randev.food_delivery.screen.dashboard.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.randev.food_delivery.R
import com.randev.food_delivery.data.getFoodList
import com.randev.food_delivery.data.getRestaurantList
import com.randev.food_delivery.screen.dashboard.home.components.NearestSection
import com.randev.food_delivery.screen.dashboard.home.components.PopularSection
import com.randev.food_delivery.ui.components.button.IconButton
import com.randev.food_delivery.ui.components.space.HorizontalSpace
import com.randev.food_delivery.ui.components.text.TextBold
import com.randev.food_delivery.ui.components.textfield.TextFieldCustom
import com.randev.food_delivery.ui.theme.FoodDeliveryTheme
import com.randev.food_delivery.ui.theme.ThirdColor

/**
 * @author Raihan Arman
 * @date 03/10/22
 */

@Composable
fun HomeScreen(
    navHostController: NavHostController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_bg_general),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    TextBold(
                        text = "Find Your Favorite Food",
                        textSize = 31.sp,
                        modifier = Modifier.width(233.dp)
                    )
                    IconButton {
                        Image(
                            painter = painterResource(id = R.drawable.ic_notification_food),
                            contentDescription = null
                        )
                    }
                }
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextFieldCustom(
                        modifier = Modifier
                            .weight(1f),
                        text = "",
                        onTextChanged = {},
                        hintText = "What do you want to order ?",
                        leadingIcon = {
                            Image(painter = painterResource(id = R.drawable.ic_search_food), contentDescription = null)
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = ThirdColor.copy(alpha = 0.1f),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        hintTextColor = ThirdColor
                    )
                    HorizontalSpace(width = 9.dp)
                    IconButton(
                        backgroundColor = ThirdColor.copy(alpha = 0.1f)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_filter_food),
                            contentDescription = null
                        )
                    }
                }
            }
            item {
                Image(
                    painter = painterResource(id = R.drawable.promo_advertising),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
            item {
                NearestSection(restaurants = getRestaurantList())
            }
            item {
                PopularSection(foods = getFoodList())
            }
        }
    }
}

@Preview
@Composable
fun PreviewHomecreen() {
    FoodDeliveryTheme {
        val navHostController = rememberNavController()
        HomeScreen(navHostController)
    }
}