package com.randev.food_delivery.ui.components.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.food_delivery.ui.theme.FoodDeliveryTheme

/**
 * @author Raihan Arman
 * @date 02/10/22
 */

@Composable
fun TextFieldOtp(
    focusRequester: FocusRequester,
    text: TextFieldValue,
    onTextChanged: (TextFieldValue) -> Unit
) {
    BasicTextField(
        value = text,
        onValueChange = onTextChanged,
        modifier = Modifier
            .background(Color.White)
            .padding(horizontal = 10.dp)
            .wrapContentSize()
            .focusRequester(focusRequester),
        maxLines = 1,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = null
        )
    ){ innerTextField ->
        Box(
            modifier = Modifier
                .width(50.dp),
            contentAlignment = Alignment.Center
        ){
            TextField(
                value = text,
                onValueChange = onTextChanged,
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Color.Black,
                    backgroundColor = Color.White,
                ),
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 33.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = null
                )
            )
        }
    }

}

@Preview
@Composable
fun PreviewTextFieldOtp() {
    FoodDeliveryTheme {
        TextFieldOtp(FocusRequester(), TextFieldValue(""), {})
    }
}