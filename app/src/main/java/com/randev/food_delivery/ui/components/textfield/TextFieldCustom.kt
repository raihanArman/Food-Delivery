package com.randev.food_delivery.ui.components.textfield

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.randev.food_delivery.ui.theme.FoodDeliveryTheme
import com.randev.food_delivery.ui.theme.GreyBorderColor
import com.randev.food_delivery.ui.theme.GreyTextColor
import com.randev.food_delivery.ui.theme.ShadowColor
import com.randev.food_delivery.ui.theme.Shapes
import com.randev.food_delivery.ui.theme.TextColor

/**
 * @author Raihan Arman
 * @date 27/09/22
 */

@SuppressLint("NewApi")
fun Modifier.drawColoredShadow(
    color: Color,
    alpha: Float = 0.07f,
    borderRadius: Dp = 0.dp,
    shadowRadius: Dp = 20.dp,
    offsetY: Dp = 20.dp,
    offsetX: Dp = 0.dp
) = this.drawBehind {
    val transparentColor = android.graphics.Color.toArgb(color.copy(alpha = 0.0f).value.toLong())
    val shadowColor = android.graphics.Color.toArgb(color.copy(alpha = alpha).value.toLong())
    this.drawIntoCanvas {
        val paint = Paint()
        val frameworkPaint = paint.asFrameworkPaint()
        frameworkPaint.color = transparentColor
        frameworkPaint.setShadowLayer(
            shadowRadius.toPx(),
            offsetX.toPx(),
            offsetY.toPx(),
            shadowColor
        )
        it.drawRoundRect(
            0f,
            0f,
            this.size.width,
            this.size.height,
            borderRadius.toPx(),
            borderRadius.toPx(),
            paint
        )
    }
}

@Composable
fun TextFieldCustom(
    modifier: Modifier = Modifier,
    text: String,
    onTextChanged: (String) -> Unit,
    hintText: String ?= null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPasswordTextFieldProvider: () -> Boolean = { false },
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(57.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Box(
            modifier = Modifier
                .drawColoredShadow(ShadowColor)
        ) {
            OutlinedTextField(
                value = text,
                onValueChange = onTextChanged,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = Color.White,
                    focusedBorderColor = GreyBorderColor,
                    unfocusedBorderColor = GreyBorderColor
                ),
                shape = Shapes.large,
                placeholder = {
                    if (hintText != null) {
                        Text(
                            hintText,
                            color = GreyTextColor.copy(alpha = 0.3f)
                        )
                    }
                },
                modifier = modifier
                    .fillMaxSize(),
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon,
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType)
            )
        }
    }
}

@Preview
@Composable
fun PreviewTextFieldCustom() {
    FoodDeliveryTheme {
        TextFieldCustom(
            hintText = "Phone number",
            text = "",
            onTextChanged = {}
        )
    }
}