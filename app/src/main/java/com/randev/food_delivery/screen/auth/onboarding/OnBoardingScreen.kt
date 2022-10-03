package com.randev.food_delivery.screen.auth.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.randev.food_delivery.R
import com.randev.food_delivery.data.onBoardingList
import com.randev.food_delivery.navigation.Screen
import com.randev.food_delivery.screen.auth.onboarding.components.OnBoardingItem
import com.randev.food_delivery.ui.components.button.PrimaryButton
import com.randev.food_delivery.ui.components.space.VerticalSpace
import com.randev.food_delivery.ui.theme.FoodDeliveryTheme
import com.randev.food_delivery.util.navigateAndReplaceStartRoute
import kotlinx.coroutines.launch

/**
 * @author Raihan Arman
 * @date 28/09/22
 */

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(
    navHostController: NavHostController
) {
    val scope = rememberCoroutineScope()
    val data = onBoardingList()
    val pagerState = rememberPagerState(pageCount = data.size)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .weight(1f)
        ) { page ->
            OnBoardingItem(onBoading = data[page])
        }
        VerticalSpace(height = 42.dp)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp),
            contentAlignment = Alignment.Center
        ) {
            PrimaryButton(
                onClick = {
                    if(pagerState.currentPage+1 < data.size){
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage+1)
                        }
                    }else {
                        navHostController.navigateAndReplaceStartRoute(Screen.SignIn.route)
                    }
                },
                text = "Next"
            )
        }
    }
}

@Preview
@Composable
fun PreviewOnBoardingScreen() {
    FoodDeliveryTheme {
        val navController = rememberNavController()
        OnBoardingScreen(navController)
    }
}