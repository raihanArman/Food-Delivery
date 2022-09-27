package com.randev.food_delivery.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.randev.food_delivery.R


private val BentoSansBold = Font(R.font.bentonsans_bold, FontWeight.Bold)
private val BentoSansMedium = Font(R.font.bentonsans_medium, FontWeight.Medium)
private val BentoSansRegular = Font(R.font.bentonsans_regular, FontWeight.Normal)
private val BentoSansLight = Font(R.font.bentonsans_light, FontWeight.Light)
private val BentoSansExtraLight = Font(R.font.bentonsans_extralight, FontWeight.ExtraLight)

private val BentoSansFamily = FontFamily(
    listOf(BentoSansBold, BentoSansMedium, BentoSansRegular, BentoSansLight, BentoSansExtraLight)
)

val Typography = Typography(
    defaultFontFamily = BentoSansFamily
)