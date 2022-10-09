package com.randev.food_delivery.screen.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.randev.food_delivery.R
import com.randev.food_delivery.navigation.Screen
import com.randev.food_delivery.navigation.setupDashboardBottomNavScreens
import com.randev.food_delivery.ui.theme.FoodDeliveryTheme

/**
 * @author Raihan Arman
 * @date 09/10/22
 */

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DashboardScreen(
    navHostController: NavHostController
) {

    val iconSize = remember { 19.dp }
    val dashboardNav = rememberNavController()

    Scaffold(
        bottomBar = {
            DashboardBottomBar(
                navController = dashboardNav,
                isDisplayed = true,
                bottomBarItems = listOf(
                    DashboardBottomBarItem(
                        icon = {
                            Image(
                                painter = painterResource(id = R.drawable.ic_dashboard_home),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(iconSize),
                            )
                        },
                        type = DashboardBottomBarItemType.HOME,
                        label = "Home",
                        route = Screen.Home.route
                    ),
                    DashboardBottomBarItem(
                        icon = {
                            Image(
                                painter = painterResource(id = R.drawable.ic_dashboard_profile),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(iconSize),
                            )
                        },
                        type = DashboardBottomBarItemType.PROFILE,
                        label = "Explore",
                        route = Screen.Profile.route
                    ),
                    DashboardBottomBarItem(
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_dashboard_buy),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(iconSize),
                            )
                        },
                        type = DashboardBottomBarItemType.CART,
                        label = "Cart",
                        notifCount = 5,
                        route = Screen.Cart.route
                    ),
                    DashboardBottomBarItem(
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_dashboard_chat),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(iconSize),
                            )
                        },
                        type = DashboardBottomBarItemType.CHAT,
                        label = "Chat",
                        route = Screen.Chat.route
                    ),
                )
            )
        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = it.calculateBottomPadding())
            ) {
                NavHost(
                    navController = dashboardNav,
                    startDestination = "dashboardBottomNav"
                ){
                    setupDashboardBottomNavScreens(navHostController)
                }
            }
        }
    )


}

@Preview
@Composable
fun PreviewDashboardScreen() {
    val navController = rememberNavController()
    FoodDeliveryTheme() {
        DashboardScreen(navHostController = navController)
    }
}