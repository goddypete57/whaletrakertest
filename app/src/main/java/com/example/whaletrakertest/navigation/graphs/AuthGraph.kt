package com.example.whaletrakertest.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.whaletrakertest.navigation.routs.AuthRouts
import com.example.whaletrakertest.navigation.routs.BottomRouts
import com.example.whaletrakertest.screen.auth.*
import com.example.whaletrakertest.screen.home.*
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi

@OptIn(ExperimentalMaterialNavigationApi::class)
fun NavGraphBuilder.authGraph(
    navController: NavController,
) {
    navigation(startDestination = AuthRouts.GettingStarted, route = AuthRouts.DEFAULT) {
        composable(AuthRouts.GettingStarted) {
            GettingStartedScreen(
                onGetStarted = { navController.navigate(AuthRouts.SignUp) },
                alreadyHaveAccount = { navController.navigate(AuthRouts.SignIn) })
        }
        composable(AuthRouts.SignIn) {
            SignIn(
                onGetStarted = { navController.navigate(AuthRouts.SignUp) },
                onLogin = { navController.navigate(BottomRouts.DEFAULT){
                    popUpTo(AuthRouts.DEFAULT) {
                        inclusive = true
                    }
                } },
                onForgotPassword = { navController.navigate(AuthRouts.ForgetPassword) }, onBackPress = {navController.navigateUp()})
        }
        composable(AuthRouts.SignUp) {
            SignUp(
                onLogin = { navController.navigate(AuthRouts.SignIn) },
                onGetStarted = { navController.navigate(AuthRouts.Otp) }, onBackPress = {navController.navigateUp()})
        }
        composable(AuthRouts.ForgetPassword) {
            ForgotPassword(onResetPassword = { navController.navigate(AuthRouts.ResetPassword) }, onBackPress = {navController.navigateUp()})
        }
        composable(AuthRouts.Otp) {
            Otp(onVerify = { navController.navigate(AuthRouts.Verification) }, onBackPress = {navController.navigateUp()})
        }
        composable(AuthRouts.ResetPassword) {
            ResetPassword( onBackPress = {navController.navigateUp()})
        }
        composable(AuthRouts.Verification) {
            VerificationSuccess(onContinue = { navController.navigate(BottomRouts.DEFAULT){
                popUpTo(AuthRouts.DEFAULT) {
                    inclusive = true
                }
            } })
        }
    }
}

