package com.randev.food_delivery.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.randev.food_delivery.screen.auth.forgot_password.ForgotPasswordScreen
import com.randev.food_delivery.screen.auth.onboarding.OnBoardingScreen
import com.randev.food_delivery.screen.auth.otp.VerificationCodeScreen
import com.randev.food_delivery.screen.auth.payment.PaymentMethod
import com.randev.food_delivery.screen.auth.reset_password.ResetPassSuccessScreen
import com.randev.food_delivery.screen.auth.reset_password.ResetPasswordScreen
import com.randev.food_delivery.screen.auth.sign_in.SignInScreen
import com.randev.food_delivery.screen.auth.sign_up.SignUpProcessScreen
import com.randev.food_delivery.screen.auth.sign_up.SignUpScreen
import com.randev.food_delivery.screen.auth.sign_up.SignUpSuccessScreen
import com.randev.food_delivery.screen.auth.upload_photo.UploadPhotoScreen
import com.randev.food_delivery.screen.dashboard.DashboardScreen
import com.randev.food_delivery.screen.splash.SplashScreen

/**
 * @author Raihan Arman
 * @date 03/10/22
 */

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(navController)
        }
        composable(Screen.OnBoarding.route) {
            OnBoardingScreen(navController)
        }
        composable(Screen.SignIn.route) {
            SignInScreen(navController)
        }
        composable(Screen.SignUp.route) {
            SignUpScreen(navController)
        }
        composable(Screen.SignUpProcess.route) {
            SignUpProcessScreen(navController)
        }
        composable(Screen.PaymentMethod.route) {
            PaymentMethod()
        }
        composable(Screen.UploadPhoto.route) {
            UploadPhotoScreen()
        }
        composable(Screen.SignUpSuccess.route) {
            SignUpSuccessScreen(navController)
        }
        composable(Screen.VerificationCode.route) {
            VerificationCodeScreen()
        }
        composable(Screen.ForgotPassword.route) {
            ForgotPasswordScreen(navController)
        }
        composable(Screen.ResetPassword.route) {
            ResetPasswordScreen(navController)
        }
        composable(Screen.ResetPasswordSuccess.route) {
            ResetPassSuccessScreen()
        }
        composable(Screen.Dashboard.route) {
            DashboardScreen()
        }
    }
}