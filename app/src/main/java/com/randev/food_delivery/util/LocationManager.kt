package com.randev.food_delivery.util

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LastLocationRequest
import com.google.android.gms.location.LocationServices

/**
 * @author Raihan Arman
 * @date 02/10/22
 */

class LocationManager(
    private val context: Context
){
    private val fusedLocationProvide: FusedLocationProviderClient by lazy {
        LocationServices.getFusedLocationProviderClient(context)
    }

    @SuppressLint("MissingPermission")
    fun getLastLocation(lastLocation: (Location) -> Unit) {
        val lastLocationRequest = LastLocationRequest.Builder()
            .build()

        fusedLocationProvide.getLastLocation(lastLocationRequest)
            .addOnFailureListener {
                it.printStackTrace()
            }
            .addOnSuccessListener {
                println("AAAAA -> $it")
                lastLocation.invoke(it)
            }

    }

}