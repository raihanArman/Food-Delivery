package com.randev.food_delivery.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.randev.food_delivery.screen.dashboard.home.HomeScreen

/**
 * @author Raihan Arman
 * @date 18/09/22
 */

@OptIn(ExperimentalMaterialApi::class)
fun NavGraphBuilder.setupDashboardBottomNavScreens(
    navHostController: NavHostController,
){
    navigation(
        startDestination = Screen.Home.route,
        route = "dashboardBottomNav"
    ){
        composable(Screen.Home.route){
            HomeScreen(navHostController)
        }
        composable(Screen.Profile.route){

        }
        composable(Screen.Cart.route){
        }
        composable(Screen.Chat.route) {
        }
    }
}