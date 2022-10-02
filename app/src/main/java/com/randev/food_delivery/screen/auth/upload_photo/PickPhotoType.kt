package com.randev.food_delivery.screen.auth.upload_photo

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.food_delivery.R
import com.randev.food_delivery.ui.components.space.VerticalSpace
import com.randev.food_delivery.ui.components.text.TextBold
import com.randev.food_delivery.ui.theme.FoodDeliveryTheme
import com.randev.food_delivery.ui.theme.ShadowColor
import com.randev.food_delivery.ui.theme.Shapes
import com.randev.food_delivery.util.drawColoredShadow

/**
 * @author Raihan Arman
 * @date 02/10/22
 */

enum class PickType{
    CAMERA,
    GALLERY
}

@Composable
fun PickPhotoType(
    pickType: PickType,
    modifier: Modifier = Modifier,
    onClick:() -> Unit
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(129.dp)
            .drawColoredShadow(ShadowColor)
            .clickable {
                onClick()
            },
        shape = Shapes.large,
        color = Color.White,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = if (pickType == PickType.CAMERA) R.drawable.ic_camera else R.drawable.ic_gallery),
                    contentDescription = null,
                    modifier = Modifier
                        .height(49.dp)
                )
                VerticalSpace(height = 10.dp)
                TextBold(text = if (pickType == PickType.CAMERA) "Take Photo" else "From Gallery" , textSize = 14.sp)
            }
        }
    }
}

@Preview
@Composable
fun PreviewPickPhotoType() {
    FoodDeliveryTheme {
        PickPhotoType(
            pickType = PickType.GALLERY,
            onClick = {}
        )
    }
}