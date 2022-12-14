package com.randev.food_delivery.screen.auth.sign_up

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.randev.food_delivery.R
import com.randev.food_delivery.navigation.Screen
import com.randev.food_delivery.ui.components.button.BackButton
import com.randev.food_delivery.ui.components.button.PrimaryButton
import com.randev.food_delivery.ui.components.space.VerticalSpace
import com.randev.food_delivery.ui.components.text.TextBold
import com.randev.food_delivery.ui.components.text.TextDescription
import com.randev.food_delivery.ui.components.textfield.TextFieldCustom
import com.randev.food_delivery.ui.theme.FoodDeliveryTheme
import com.randev.food_delivery.util.navigateAndReplaceStartRoute

/**
 * @author Raihan Arman
 * @date 02/10/22
 */

@Composable
fun SignUpProcessScreen(
    navHostController: NavHostController
) {

    var firstName by remember {
        mutableStateOf("")
    }

    var lastName by remember {
        mutableStateOf("")
    }

    var mobileNumber by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Image(
            painter = painterResource(id = R.drawable.ic_bg_general),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(),
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
                text = "Fill in your bio to get started",
                textSize = 25.sp,
                modifier = Modifier
                    .width(264.dp)
            )
            TextDescription(
                text = "This data will be displayed in your account profile for security",
                textSize = 12.sp,
                modifier = Modifier.width(239.dp)
            )
            TextFieldCustom(
                text = firstName,
                onTextChanged = { firstName = it },
                hintText = "First name"
            )
            TextFieldCustom(
                text = lastName,
                onTextChanged = { lastName = it },
                hintText = "Last name"
            )
            TextFieldCustom(
                text = mobileNumber,
                onTextChanged = { mobileNumber = it },
                hintText = "Mobile number",
                keyboardType = KeyboardType.Number
            )
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                PrimaryButton(
                    onClick = {
                        navHostController.navigateAndReplaceStartRoute(Screen.SignUpSuccess.route)
                    },
                    text = "Next"
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewSignUpProcessScreen() {
    FoodDeliveryTheme {
        val navHostController = rememberNavController()
        SignUpProcessScreen(navHostController)
    }
}