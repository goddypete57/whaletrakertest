package com.example.whaletrakertest

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.whaletrakertest.navigation.BottomNav
import com.example.whaletrakertest.navigation.TopNavBar
import com.example.whaletrakertest.navigation.graphs.authGraph
import com.example.whaletrakertest.navigation.graphs.bottomGraph
import com.example.whaletrakertest.navigation.graphs.mainGraph
import com.example.whaletrakertest.navigation.graphs.settingGraph
import com.example.whaletrakertest.navigation.routs.AuthRouts
import com.example.whaletrakertest.navigation.routs.BottomRouts
import com.example.whaletrakertest.navigation.routs.MainRouts
import com.example.whaletrakertest.navigation.routs.SettingsRouts
import com.example.whaletrakertest.ui.theme.Black_alpha
import com.example.whaletrakertest.ui.theme.Divider_color
import com.example.whaletrakertest.ui.theme.WhaletrakertestTheme
import com.google.accompanist.navigation.material.BottomSheetNavigator
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialNavigationApi::class, ExperimentalMaterialApi::class)
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            val bottomSheetState =
                rememberModalBottomSheetState(
                    initialValue = ModalBottomSheetValue.Hidden,
                    skipHalfExpanded = true,
//            animationSpec = tween(
//                durationMillis = 0,
//                delayMillis = 10,
//                easing = FastOutLinearInEasing
//            )

                )
            var startDestination = AuthRouts.DEFAULT
            val bottomSheetNavigator = BottomSheetNavigator(bottomSheetState)
            val navController = rememberNavController(bottomSheetNavigator)
            val navBackStackEntry by navController.currentBackStackEntryAsState()

            WhaletrakertestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    com.google.accompanist.navigation.material.ModalBottomSheetLayout(
                        sheetElevation = 20.dp,
                        scrimColor = Color.Black.copy(0.30f),
                        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                        sheetBackgroundColor = Black_alpha,
                        bottomSheetNavigator = bottomSheetNavigator,
                    ) {
                        Scaffold(
                            bottomBar = {
                            if (navBackStackEntry?.destination?.parent?.route == BottomRouts.DEFAULT) {
                                BottomNav(navController = navController)
                            }

                        },
                            topBar = {
                                when(navBackStackEntry?.destination?.parent?.route){
                                    MainRouts.DEFAULT,BottomRouts.DEFAULT, SettingsRouts.DEFAULT->{
                                        when(navBackStackEntry?.destination?.route){
                                            BottomRouts.HOME,MainRouts.NotificationScreen,BottomRouts.TokenSheet->{
                                            }
                                            else->{
                                                Column {
                                                    TopNavBar(
                                                        navController = navController,
                                                        onDeleteWalletSheet = { navController.navigate(MainRouts.Delete_Wallet_Sheet) },
                                                        onEditWhaleSheet = { navController.navigate(MainRouts.EditWhaleSheet) },
                                                        onDeleteWhaleSheet = {navController.navigate(MainRouts.Delete_Whale_Sheet)}
                                                    )
                                                    Divider(
                                                        thickness = 1.dp,
                                                        modifier = Modifier.fillMaxWidth(),
                                                        color = Divider_color
                                                    )
                                                }
                                            }
                                        }


                                    }
                                }

                            }
                            ,content = {
                            Column(modifier = Modifier.fillMaxSize()) {
                                NavHost(
                                    navController = navController,
                                    startDestination = startDestination,
                                    modifier = Modifier.weight(1f)
                                ) {
                                    mainGraph(
                                        navController = navController,
                                    )
                                    settingGraph(navController = navController)
                                    bottomGraph(navController)
                                    authGraph(navController)


                                }
                            }
                        })


                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WhaletrakertestTheme {

    }
}