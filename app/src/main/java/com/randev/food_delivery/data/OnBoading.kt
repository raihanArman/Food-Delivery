package com.randev.food_delivery.data

import com.randev.food_delivery.R

/**
 * @author Raihan Arman
 * @date 28/09/22
 */

data class OnBoading(
    val image: Int,
    val title: String,
    val description: String
)

fun onBoardingList(): List<OnBoading> = listOf(
    OnBoading(
        image = R.drawable.ic_illustartion_1,
        title = "Find your  Comfort Food here",
        description = "Here You Can find a chef or dish for every taste and color. Enjoy!"
    ),
    OnBoading(
        image = R.drawable.ic_illustration_2,
        title = "Food Ninja is Where Your Comfort Food Lives",
        description = "Enjoy a fast and smooth food delivery at your doorstep"
    ),
)