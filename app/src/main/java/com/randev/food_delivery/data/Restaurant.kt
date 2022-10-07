package com.randev.food_delivery.data

import com.randev.food_delivery.R

/**
 * @author Raihan Arman
 * @date 07/10/22
 */
data class Restaurant(
    val image: Int,
    val title: String,
    val time: String
)

fun getRestaurantList() = listOf(
    Restaurant(
        image = R.drawable.vegan,
        title = "Vegan Resto",
        time = "12 Mins"
    ),
    Restaurant(
        image = R.drawable.healthy,
        title = "Healthy Food",
        time = "8 Mins"
    ),
    Restaurant(
        image = R.drawable.good_food,
        title = "Good Food",
        time = "12 Mins"
    ),
    Restaurant(
        image = R.drawable.smart_food,
        title = "Smart Food",
        time = "12 Mins"
    )
)