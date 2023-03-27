package com.example.whaletrakertest.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.whaletrakertest.navigation.routs.BottomRouts

import com.example.whaletrakertest.navigation.routs.MainRouts
import com.example.whaletrakertest.navigation.routs.SettingsRouts
import com.example.whaletrakertest.screen.activity.Activity
import com.example.whaletrakertest.screen.activity.DateRange
import com.example.whaletrakertest.screen.home.Home
import com.example.whaletrakertest.screen.home.TokenSheet
import com.example.whaletrakertest.screen.settings.Settings

import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.bottomSheet


@OptIn(ExperimentalMaterialNavigationApi::class)
fun NavGraphBuilder.bottomGraph(
    navController: NavController,

    ) {
    navigation(startDestination = BottomRouts.HOME, route = BottomRouts.DEFAULT) {

        composable(BottomRouts.HOME) {
            Home(
                navController,
                onTokenClick = { navController.navigate(BottomRouts.TokenSheet) },
                onOpenNotification = { navController.navigate(MainRouts.NotificationScreen) },
                onProfileClick =  {navController.navigate(MainRouts.Profile)})
        }

        composable(BottomRouts.Activity) {
            Activity(onCalenderClick = {navController.navigate(BottomRouts.DataRange)})
        }
        composable(BottomRouts.DataRange) {
            DateRange()
        }
        composable(BottomRouts.Settings) {
            Settings(
                onChangePassword = { navController.navigate(SettingsRouts.ChangePassword) },
                onSecurity = { navController.navigate(SettingsRouts.SecurityScreen) },
                onPriceClick = { navController.navigate(SettingsRouts.PriceLimit) })
        }
        bottomSheet(BottomRouts.TokenSheet) {
            TokenSheet(onClose = { navController.popBackStack() }, onEditTokenSheet = {navController.navigate(MainRouts.EditTokenDetailsSheet)})
        }

    }
}
