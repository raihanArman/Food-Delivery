package com.randev.food_delivery.screen.auth.sign_up

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.randev.food_delivery.navigation.Screen
import com.randev.food_delivery.ui.components.button.PrimaryButton
import com.randev.food_delivery.ui.components.space.VerticalSpace
import com.randev.food_delivery.ui.components.text.TextBold
import com.randev.food_delivery.ui.components.text.TextGradient
import com.randev.food_delivery.ui.theme.FoodDeliveryTheme
import com.randev.food_delivery.util.navigateAndReplaceStartRoute

/**
 * @author Raihan Arman
 * @date 02/10/22
 */

@Composable
fun SignUpSuccessScreen(
    navHostController: NavHostController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Image(
            painter = painterResource(id = R.drawable.ic_bg_auth),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(id = R.drawable.ic_done_illustration), contentDescription = null)
                VerticalSpace(height = 33.dp)
                TextGradient(text = "Congrats !", textSize = 30.sp)
                VerticalSpace(height = 12.dp)
                TextBold(text = "Your Profile Is Ready To Use", textSize = 23.sp)
            }
            PrimaryButton(
                onClick = {
                    navHostController.navigateAndReplaceStartRoute(Screen.Dashboard.route)
                },
                text = "Try Order"
            )
        }
    }
}

@Preview
@Composable
fun PreviewSignUpSuccessScreen() {
    FoodDeliveryTheme {
        val navHostController = rememberNavController()
        SignUpSuccessScreen(navHostController)
    }
}