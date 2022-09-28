package com.randev.food_delivery.screen.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.food_delivery.data.OnBoading
import com.randev.food_delivery.data.onBoardingList
import com.randev.food_delivery.ui.components.space.VerticalSpace
import com.randev.food_delivery.ui.components.text.TextBold
import com.randev.food_delivery.ui.components.text.TextDescription
import com.randev.food_delivery.ui.theme.FoodDeliveryTheme

/**
 * @author Raihan Arman
 * @date 28/09/22
 */

@Composable
fun OnBoardingItem(
    modifier: Modifier = Modifier,
    onBoading: OnBoading
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = onBoading.image),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        VerticalSpace(height = 38.dp)
        TextBold(
            modifier = Modifier
                .width(211.dp),
            text = "Find your Comfort Food here",
            textSize = 22.sp,
            textAlign = TextAlign.Center
        )
        VerticalSpace(height = 20.dp)
        TextDescription(
            text = onBoading.description,
            textSize = 12.sp,
            modifier = Modifier.width(244.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun PreviewOnBoardingItem() {
    FoodDeliveryTheme() {
        OnBoardingItem(onBoading = onBoardingList()[0])
    }
}