package com.randev.food_delivery.screen.auth.forgot_password

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Surface
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
import com.randev.food_delivery.screen.auth.payment.PaymentMethodItem
import com.randev.food_delivery.ui.components.button.BackButton
import com.randev.food_delivery.ui.components.button.PrimaryButton
import com.randev.food_delivery.ui.components.space.HorizontalSpace
import com.randev.food_delivery.ui.components.space.VerticalSpace
import com.randev.food_delivery.ui.components.text.TextBold
import com.randev.food_delivery.ui.components.text.TextDescription
import com.randev.food_delivery.ui.theme.FoodDeliveryTheme
import com.randev.food_delivery.ui.theme.ShadowColor
import com.randev.food_delivery.ui.theme.Shapes
import com.randev.food_delivery.util.drawColoredShadow

/**
 * @author Raihan Arman
 * @date 03/10/22
 */

@Composable
fun ForgotPasswordScreen(
    navHostController: NavHostController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Image(
            painter = painterResource(id = R.drawable.ic_bg_general),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .padding(25.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            BackButton() {

            }
            TextBold(
                text = "Forgot password?",
                textSize = 25.sp,
                modifier = Modifier
                    .width(264.dp)
            )
            TextDescription(
                text = "Select which contact details should we use to reset your password",
                textSize = 12.sp,
                modifier = Modifier.width(239.dp)
            )
            Surface(
                color = Color.White,
                shape = Shapes.large,
                modifier = Modifier
                    .fillMaxWidth()
                    .drawColoredShadow(ShadowColor)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(25.dp),
                ){
                    Image(
                        painter = painterResource(id = R.drawable.ic_chat),
                        contentDescription = null,
                        modifier = Modifier
                            .size(33.dp)
                    )
                    HorizontalSpace(width = 20.dp)
                    Column(
                        modifier = Modifier
                            .weight(1f),
                        horizontalAlignment = Alignment.Start
                    ) {
                        TextDescription(text = "Via sms :", textSize = 16.sp)
                        TextDescription(text = "0825 xxxx xxxx", textSize = 16.sp, textColor = Color.Black)
                    }
                }
            }
            Surface(
                color = Color.White,
                shape = Shapes.large,
                modifier = Modifier
                    .fillMaxWidth()
                    .drawColoredShadow(ShadowColor)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(25.dp),
                ){
                    Image(
                        painter = painterResource(id = R.drawable.ic_message),
                        contentDescription = null,
                        modifier = Modifier
                            .size(33.dp)
                    )
                    HorizontalSpace(width = 20.dp)
                    Column(
                        modifier = Modifier
                            .weight(1f),
                        horizontalAlignment = Alignment.Start
                    ) {
                        TextDescription(text = "Via email :", textSize = 16.sp)
                        TextDescription(text = "xxxx @gmail.com", textSize = 16.sp, textColor = Color.Black)
                    }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                PrimaryButton(
                    onClick = {
                        navHostController.navigate(Screen.ResetPassword.route)
                    },
                    text = "Next"
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewForgotPasswordScreen() {
    FoodDeliveryTheme {
        val navController = rememberNavController()
        ForgotPasswordScreen(navController)
    }
}