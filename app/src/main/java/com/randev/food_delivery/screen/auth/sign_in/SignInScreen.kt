package com.randev.food_delivery.screen.auth.sign_in

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.randev.food_delivery.R
import com.randev.food_delivery.navigation.Screen
import com.randev.food_delivery.ui.components.button.PrimaryButton
import com.randev.food_delivery.ui.components.button.SocialMediaButton
import com.randev.food_delivery.ui.components.button.TextButtonCustom
import com.randev.food_delivery.ui.components.space.VerticalSpace
import com.randev.food_delivery.ui.components.text.TextBold
import com.randev.food_delivery.ui.components.textfield.TextFieldCustom
import com.randev.food_delivery.ui.theme.FoodDeliveryTheme
import com.randev.food_delivery.util.navigateAndReplaceStartRoute

/**
 * @author Raihan Arman
 * @date 27/09/22
 */

@Composable
fun SignInScreen(
    navController: NavHostController
) {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

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
                .padding(25.dp)
                .verticalScroll(rememberScrollState()),
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
                text = email,
                onTextChanged = {
                    email = it
                },
                hintText = "Email"
            )
            VerticalSpace(height = 12.dp)
            TextFieldCustom(
                text = password,
                onTextChanged = {
                    password = it
                },
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
                    onClick = {
                          navController.navigate(Screen.SignUp.route)
                    },
                    text = "Google",
                    imageResource = R.drawable.ic_google,
                    modifier = Modifier.weight(1f)
                )
            }
            VerticalSpace(height = 20.dp)
            TextButtonCustom(text = "Forgot Password ?", onClick = {
                navController.navigate(Screen.ForgotPassword.route)
            })
            VerticalSpace(height = 36.dp)
            PrimaryButton(onClick = {
                                    navController.navigateAndReplaceStartRoute(Screen.Dashboard.route)
            }, text = "Login", modifier = Modifier.width(141.dp))
            VerticalSpace(height = 20.dp)
        }
    }
}

@Preview
@Composable
fun PreviewSignInScreen() {
    FoodDeliveryTheme {
        val navController = rememberNavController()
        SignInScreen(navController)
    }
}