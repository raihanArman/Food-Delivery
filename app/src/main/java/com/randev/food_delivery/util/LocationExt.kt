package com.randev.food_delivery.util

import android.content.Context
import android.location.Geocoder
import android.location.Location
import com.google.android.gms.maps.model.LatLng
import java.util.*

/**
 * @author Raihan Arman
 * @date 02/10/22
 */

fun Location.toLatLng(): LatLng {
    return LatLng(latitude, longitude)
}

fun Location.toAddress(
    context: Context
): String {
    val latlng = this.toLatLng()
    val geocoder = Geocoder(context, Locale.getDefault())

    val address = geocoder.getFromLocation(latlng.latitude, latlng.longitude, 1)

    return address[0].getAddressLine(0)
}