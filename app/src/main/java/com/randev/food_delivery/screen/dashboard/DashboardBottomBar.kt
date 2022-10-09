package com.randev.food_delivery.screen.dashboard

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.randev.food_delivery.R
import com.randev.food_delivery.navigation.Screen
import com.randev.food_delivery.ui.theme.FoodDeliveryTheme
import com.randev.food_delivery.ui.theme.PrimaryColor
import com.randev.food_delivery.ui.theme.ShadowColor
import com.randev.food_delivery.ui.theme.Shapes
import com.randev.food_delivery.util.drawColoredShadow

/**
 * @author Raihan Arman
 * @date 09/10/22
 */

enum class DashboardBottomBarItemType {
    HOME, PROFILE, CART, CHAT
}

data class DashboardBottomBarItem(
    val icon: @Composable () -> Unit,
    val label: String,
    val notifCount: Int? = null,
    val type: DashboardBottomBarItemType,
    val route: String
)

@Composable
fun DashboardBottomBar(
    isDisplayed: Boolean,
    bottomBarItems: List<DashboardBottomBarItem>,
    navController: NavHostController
) {
    val surfaceColor = Color.White
    val contentColor = PrimaryColor

    AnimatedVisibility(
        visible = isDisplayed,
        enter = slideInVertically(animationSpec = tween(), initialOffsetY = {it}),
        exit = slideOutVertically(animationSpec = tween(), targetOffsetY = {it})
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .drawColoredShadow(ShadowColor),
            shape = Shapes.large,
            elevation = 0.dp
        ) {
            BottomNavigation(
                backgroundColor = surfaceColor,
                contentColor = contentColor,
                modifier = Modifier
                    .padding(10.dp)
                    .graphicsLayer {
                        clip = true
                        shadowElevation = 0f
                    }
            ) {
                bottomBarItems.forEach { item ->
                    if(!DashboardBottomBarItemType.values().contains(item.type)){
                        throw Exception("Unknown item type! Please add this type inside the DashboardBottomBarItemType enum class.")
                    }

                    val background = if(currentRoute == item.route) PrimaryColor.copy(alpha = 0.1f) else Color.Transparent
                    val selected = currentRoute == item.route

                    BottomNavigationItem(
                        selected = selected,
                        onClick = {
                            navController.navigate(item.route)
                        },
                        icon = {
                            Box(
                                modifier = Modifier
                                    .clip(Shapes.large)
                                    .background(background)
                            ){
                                Row(
                                    modifier = Modifier
                                        .padding(10.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    IconIndicator(
                                        count = item.notifCount,
                                        forceCircleShape = false,
                                        modifier = Modifier.padding(8.dp)
                                    ) {
                                        item.icon()
                                    }

                                    AnimatedVisibility(visible = selected) {
                                        Text(
                                            text = item.label,
                                            fontSize = 10.sp,
                                            color = Color.Black
                                        )
                                    }
                                }
                            }
                        },
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewDashboardBottomBar() {
    FoodDeliveryTheme() {
        val iconSize = remember { 24.dp }
        val navHostController = rememberNavController()

        DashboardBottomBar(
            navController = navHostController,
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
    }
}