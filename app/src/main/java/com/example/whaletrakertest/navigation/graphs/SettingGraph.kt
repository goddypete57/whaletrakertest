package com.example.whaletrakertest.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.whaletrakertest.navigation.routs.MainRouts
import com.example.whaletrakertest.navigation.routs.SettingsRouts
import com.example.whaletrakertest.screen.home.*
import com.example.whaletrakertest.screen.settings.ChangePassword
import com.example.whaletrakertest.screen.settings.PriceLimit
import com.example.whaletrakertest.screen.settings.SecurityScreen
import com.example.whaletrakertest.screen.settings.SecurityTimeSheet
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.bottomSheet

@OptIn(ExperimentalMaterialNavigationApi::class)
//@Composable
//fun NavGraphBuilder.settingGraph(
//    navController: NavController
//) {
//
//        navigation(startDestination = SettingsRouts.ChangePassword, route = SettingsRouts.DEFAULT) {
//
//            composable(SettingsRouts.ChangePassword) {
//                ChangePassword()
//            }
//
//
//        }
//    }
//
//

//
//
//@OptIn(ExperimentalMaterialNavigationApi::class)
fun NavGraphBuilder.settingGraph(
    navController: NavController,
) {
    navigation(startDestination =SettingsRouts.ChangePassword, route = SettingsRouts.DEFAULT) {
        composable(SettingsRouts.ChangePassword) {
            ChangePassword()
        }
        composable(SettingsRouts.SecurityScreen) {
            SecurityScreen(onDropDown = {navController.navigate(SettingsRouts.SecurityTimeSheet)})
        }
        composable(SettingsRouts.PriceLimit) {
           PriceLimit()
        }
        bottomSheet(SettingsRouts.SecurityTimeSheet){
            SecurityTimeSheet()
        }
    }
}


