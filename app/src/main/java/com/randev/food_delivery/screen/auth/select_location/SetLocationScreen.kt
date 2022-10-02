package com.randev.food_delivery.screen.auth.select_location

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.randev.food_delivery.R
import com.randev.food_delivery.screen.auth.payment.PaymentMethodItem
import com.randev.food_delivery.ui.components.button.BackButton
import com.randev.food_delivery.ui.components.button.PrimaryButton
import com.randev.food_delivery.ui.components.button.SecondaryButton
import com.randev.food_delivery.ui.components.space.HorizontalSpace
import com.randev.food_delivery.ui.components.space.VerticalSpace
import com.randev.food_delivery.ui.components.text.TextBold
import com.randev.food_delivery.ui.components.text.TextDescription
import com.randev.food_delivery.ui.theme.FoodDeliveryTheme
import com.randev.food_delivery.ui.theme.GreyButtonColor
import com.randev.food_delivery.ui.theme.ShadowColor
import com.randev.food_delivery.ui.theme.Shapes
import com.randev.food_delivery.util.ComposeFileProvider
import com.randev.food_delivery.util.LocationManager
import com.randev.food_delivery.util.drawColoredShadow
import com.randev.food_delivery.util.toAddress
import com.randev.food_delivery.util.toLatLng

/**
 * @author Raihan Arman
 * @date 02/10/22
 */

@Composable
fun SetLocationScreen() {

    val context = LocalContext.current
    val locationManager = LocationManager(context)

    val permissions = arrayOf(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION
    )

    var currentLocation by remember {
        mutableStateOf("Your Location")
    }

    val launcherMultiplePermissions = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissionsMap ->
        val areGranted = permissionsMap.values.reduce { acc, next -> acc && next }
        if (areGranted) {
            // Use location
            getLocation(locationManager, context) {
                currentLocation = it
            }
        } else {
            // Show dialog
        }
    }

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
                text = "Set Your Location ",
                textSize = 25.sp,
                modifier = Modifier
                    .width(264.dp)
            )
            TextDescription(
                text = "This data will be displayed in your account profile for security",
                textSize = 12.sp,
                modifier = Modifier.width(239.dp)
            )
            Card(
                shape = Shapes.large,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .drawColoredShadow(ShadowColor),
                elevation = 0.dp
            ){
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.ic_pin),
                            contentDescription = null,
                            modifier = Modifier
                                .size(33.dp)
                        )
                        HorizontalSpace(width = 10.dp)
                        TextBold(text = currentLocation, textSize = 15.sp)
                    }
                    VerticalSpace(height = 30.dp)
                    SecondaryButton(
                        text = "Set Location",
                        onClick = {
                            if(
                                permissions.all {
                                    ContextCompat.checkSelfPermission(
                                        context,
                                        it
                                    ) == PackageManager.PERMISSION_GRANTED
                                }
                            ) {
                                getLocation(locationManager, context) {
                                    currentLocation = it
                                }
                            } else {
                                launcherMultiplePermissions.launch(permissions)
                            }
                        }
                    )
                }
            }
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

fun getLocation(locationManager: LocationManager, context: Context ,onTextChanged: (String) -> Unit ) {
    locationManager.getLastLocation {
        onTextChanged.invoke(it.toAddress(context))
    }
}

@Preview
@Composable
fun PreviewSetLocationScreen() {
    FoodDeliveryTheme {
        SetLocationScreen()
    }
}