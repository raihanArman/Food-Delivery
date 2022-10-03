package com.randev.food_delivery.navigation

/**
 * @author Raihan Arman
 * @date 03/10/22
 */

sealed class Screen(
    val route: String
) {
    object Splash: Screen("splash")
    object OnBoarding: Screen("onboarding")
    object SignIn: Screen("sign_in")
    object SignUp: Screen("sign_up")
    object SignUpProcess: Screen("sign_up_process")
    object PaymentMethod: Screen("payment_method")
    object UploadPhoto: Screen("upload_photo")
    object SignUpSuccess: Screen("sign_up_success")
    object VerificationCode: Screen("verification_code")
    object ForgotPassword: Screen("forgot_password")
    object ResetPassword: Screen("reset_password")
    object ResetPasswordSuccess: Screen("reset_password_success")
    object Dashboard: Screen("dashboard")
}
