package com.randev.food_delivery.data

import com.randev.food_delivery.R

/**
 * @author Raihan Arman
 * @date 07/10/22
 */

data class Food(
    val image: Int,
    val title: String,
    val description: String,
    val price: String
)

fun getFoodList() = listOf(
    Food(
        image = R.drawable.herbal,
        title = "Herbal Pancake",
        description = "Warung Herbal",
        price = "\$7"
    ),
    Food(
        image = R.drawable.fruit_salad,
        title = "Fruit Salad",
        description = "Wiji Resto",
        price = "\$5"
    ),
    Food(
        image = R.drawable.green_noddle,
        title = "Green Noddle",
        description = "Noddle Home",
        price = "\$15"
    ),
)