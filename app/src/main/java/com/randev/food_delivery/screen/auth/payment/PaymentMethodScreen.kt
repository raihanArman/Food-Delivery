package com.randev.food_delivery.screen.auth.payment

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
import com.randev.food_delivery.ui.components.button.BackButton
import com.randev.food_delivery.ui.components.button.PrimaryButton
import com.randev.food_delivery.ui.components.text.TextBold
import com.randev.food_delivery.ui.components.text.TextDescription
import com.randev.food_delivery.ui.components.textfield.TextFieldCustom
import com.randev.food_delivery.ui.theme.FoodDeliveryTheme

/**
 * @author Raihan Arman
 * @date 02/10/22
 */

@Composable
fun PaymentMethod() {
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
                text = "Payment Method",
                textSize = 25.sp,
                modifier = Modifier
                    .width(264.dp)
            )
            TextDescription(
                text = "This data will be displayed in your account profile for security",
                textSize = 12.sp,
                modifier = Modifier.width(239.dp)
            )
            PaymentMethodItem(image = R.drawable.ic_paypal)
            PaymentMethodItem(image = R.drawable.ic_visa)
            PaymentMethodItem(image = R.drawable.ic_payoneer)
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                PrimaryButton(onClick = {}, text = "Next")
            }
        }
    }
}


@Preview
@Composable
fun PreviewPaymentMethod() {
    FoodDeliveryTheme {
        PaymentMethod()
    }
}