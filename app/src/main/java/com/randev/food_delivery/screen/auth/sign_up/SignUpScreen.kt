package com.randev.food_delivery.screen.auth.sign_up

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.food_delivery.R
import com.randev.food_delivery.ui.components.button.PrimaryButton
import com.randev.food_delivery.ui.components.button.SocialMediaButton
import com.randev.food_delivery.ui.components.button.TextButtonCustom
import com.randev.food_delivery.ui.components.space.VerticalSpace
import com.randev.food_delivery.ui.components.text.TextBold
import com.randev.food_delivery.ui.components.textfield.TextFieldCustom
import com.randev.food_delivery.ui.theme.FoodDeliveryTheme

/**
 * @author Raihan Arman
 * @date 28/09/22
 */

@Composable
fun SignUpScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
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
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = null,
                modifier = Modifier
                    .height(203.dp)
                    .width(188.dp)
            )
            VerticalSpace(height = 60.dp)
            TextBold(text = "Sign Up For Free", textSize = 20.sp)
            VerticalSpace(height = 40.dp)
            TextFieldCustom(
                text = "",
                onTextChanged = {},
                hintText = "Username",
                leadingIcon = {
                    IconLeading(resource = R.drawable.ic_profile)
                }
            )
            VerticalSpace(height = 12.dp)
            TextFieldCustom(
                text = "",
                onTextChanged = {},
                hintText = "Email",
                leadingIcon = {
                    IconLeading(resource = R.drawable.ic_message)
                }
            )
            VerticalSpace(height = 12.dp)
            TextFieldCustom(
                text = "",
                onTextChanged = {},
                hintText = "Password",
                isPasswordTextFieldProvider = {true},
                leadingIcon = {
                    IconLeading(resource = R.drawable.ic_lock)
                }
            )

            VerticalSpace(height = 36.dp)
            PrimaryButton(onClick = {}, text = "Login", modifier = Modifier.width(141.dp))
            VerticalSpace(height = 20.dp)
            TextButtonCustom(text = "already have account ?", onClick = {})
        }
    }
}

@Composable
fun IconLeading(
    resource: Int
) {
    Icon(
        painter = painterResource(id = resource),
        contentDescription = null,
        modifier = Modifier.size(24.dp),
        tint= Color.Unspecified
    )
}

@Preview
@Composable
fun SignUpPreviewSignInScreen() {
    FoodDeliveryTheme {
        SignUpScreen()
    }
}