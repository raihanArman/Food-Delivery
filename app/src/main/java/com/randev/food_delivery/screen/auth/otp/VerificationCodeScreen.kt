package com.randev.food_delivery.screen.auth.otp

import android.annotation.SuppressLint
import android.widget.Toast
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
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.food_delivery.R
import com.randev.food_delivery.screen.auth.payment.PaymentMethodItem
import com.randev.food_delivery.ui.components.button.BackButton
import com.randev.food_delivery.ui.components.button.PrimaryButton
import com.randev.food_delivery.ui.components.text.TextBold
import com.randev.food_delivery.ui.components.text.TextDescription
import com.randev.food_delivery.ui.components.textfield.TextFieldOtp
import com.randev.food_delivery.ui.theme.FoodDeliveryTheme
import com.randev.food_delivery.ui.theme.ShadowColor
import com.randev.food_delivery.ui.theme.Shapes
import com.randev.food_delivery.util.drawColoredShadow
import kotlinx.coroutines.delay

/**
 * @author Raihan Arman
 * @date 02/10/22
 */

@SuppressLint("UnrememberedMutableState")
@Composable
fun VerificationCodeScreen() {

    val context = LocalContext.current

    val listTextOtp = listOf(
        mutableStateOf(
            TextFieldValue(text = "", selection = TextRange(0))
        ),
        mutableStateOf(
            TextFieldValue(text = "", selection = TextRange(0))
        ),
        mutableStateOf(
            TextFieldValue(text = "", selection = TextRange(0))
        ),
        mutableStateOf(
            TextFieldValue(text = "", selection = TextRange(0))
        )
    )

    val listRequester = listOf(
        FocusRequester(),
        FocusRequester(),
        FocusRequester(),
        FocusRequester(),
    )

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
                text = "Enter 4-digit Verification code",
                textSize = 25.sp,
                modifier = Modifier
                    .width(207.dp)
            )
            TextDescription(
                text = "Code send to +6282045**** . This code will expired in 01:30",
                textSize = 12.sp,
                modifier = Modifier.width(239.dp)
            )
            Card(
                shape = Shapes.large,
                elevation = 0.dp,
                backgroundColor = Color.White,
                modifier = Modifier
                    .drawColoredShadow(ShadowColor)
            ) {
                ContentOtp(textList = listTextOtp, requesterList = listRequester)
            }
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                PrimaryButton(onClick = {
                    validateOtp(textList = listTextOtp) { isSuccess ->
                        if(isSuccess) {
                            // Next Page
                        } else {
                            Toast.makeText(context, "OTP Salah", Toast.LENGTH_SHORT).show()
                        }
                    }
                }, text = "Next")
            }
        }
    }
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun ContentOtp(
    textList: List<MutableState<TextFieldValue>>,
    requesterList: List<FocusRequester>
) {
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 30.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        for (i in textList.indices){
            TextFieldOtp(
                focusRequester = requesterList[i],
                text = textList[i].value,
                onTextChanged = { newValue ->
                    if(textList[i].value.text != "") {
                        if(newValue.text == "") {
                            textList[i].value = TextFieldValue(
                                text = "",
                                selection = TextRange(0)
                            )
                        }
                        return@TextFieldOtp
                    }

                    textList[i].value = TextFieldValue(
                        text = newValue.text,
                        selection = TextRange(newValue.text.length)
                    )

                    nextFocus(textList, requesterList)
                }
            )
        }
    }
    
    LaunchedEffect(key1 = null) {
        delay(300)
        requesterList[0].requestFocus()
    }
}

private fun nextFocus(
    textList: List<MutableState<TextFieldValue>>,
    requesterList: List<FocusRequester>
) {
    for (index in textList.indices) {
        if (textList[index].value.text == "") {
            if (index < textList.size) {
                requesterList[index].requestFocus()
                break
            }
        }
    }
}

private fun validateOtp(
    textList: List<MutableState<TextFieldValue>>,
    onVerifyCode: ((success: Boolean) -> Unit)? = null
) {
    var code = ""
    for(text in textList) {
        code += text.value.text
    }

    if(code.length == 4) {
        verifyCode(code = code, onSuccess = {
            onVerifyCode?.let {
                it(true)
            }
        }, onError = {
            onVerifyCode?.let {
                it(false)
            }
        })
    }
}

private fun verifyCode(
    code: String,
    onSuccess: () -> Unit,
    onError: () -> Unit
) {
    if(code == "4321") {
        onSuccess()
    }else{
        onError()
    }
}

@Preview
@Composable
fun PreviewVerificationCodeScreen() {
    FoodDeliveryTheme {
        VerificationCodeScreen()
    }
}