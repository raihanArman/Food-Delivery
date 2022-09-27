package com.randev.food_delivery.screen

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
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
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
import com.randev.food_delivery.R
import com.randev.food_delivery.ui.components.button.PrimaryButton
import com.randev.food_delivery.ui.components.button.SocialMediaButton
import com.randev.food_delivery.ui.components.button.TextButtonCustom
import com.randev.food_delivery.ui.components.space.VerticalSpace
import com.randev.food_delivery.ui.components.text.TextBold
import com.randev.food_delivery.ui.components.textfield.TextFieldCustom
import com.randev.food_delivery.ui.theme.FoodDeliveryTheme
import com.randev.food_delivery.ui.theme.PrimaryColor
import com.randev.food_delivery.ui.theme.TextColor

/**
 * @author Raihan Arman
 * @date 27/09/22
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
            TextBold(text = "Login To Your Account", textSize = 20.sp)
            VerticalSpace(height = 40.dp)
            TextFieldCustom(
                text = "",
                onTextChanged = {},
                hintText = "Email"
            )
            VerticalSpace(height = 12.dp)
            TextFieldCustom(
                text = "",
                onTextChanged = {},
                hintText = "Password"
            )
            VerticalSpace(height = 20.dp)
            TextBold(text = "Or Continue With", textSize = 12.sp)
            VerticalSpace(height = 20.dp)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(21.dp)
            ){
                SocialMediaButton(
                    onClick = {},
                    text = "Facebook",
                    imageResource = R.drawable.ic_facebook,
                    modifier = Modifier.weight(1f)
                )
                SocialMediaButton(
                    onClick = {},
                    text = "Google",
                    imageResource = R.drawable.ic_google,
                    modifier = Modifier.weight(1f)
                )
            }
            VerticalSpace(height = 20.dp)
            TextButtonCustom(text = "Forgot Password ?", onClick = {})
            VerticalSpace(height = 36.dp)
            PrimaryButton(onClick = {}, text = "Login", modifier = Modifier.width(141.dp))
        }
    }
}

@Preview
@Composable
fun PreviewSignUpScreen() {
    FoodDeliveryTheme {
        SignUpScreen()
    }
}