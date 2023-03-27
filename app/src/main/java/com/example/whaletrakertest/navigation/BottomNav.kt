package com.example.whaletrakertest.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.whaletrakertest.BottomNavData
import com.example.whaletrakertest.navigation.routs.BottomRouts
import com.example.whaletrakertest.ui.theme.Black_alpha
import com.example.whaletrakertest.ui.theme.Sub_Text

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomNav(
    navController: NavController,

    ) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val items = listOf(
        BottomNavData.home,
        BottomNavData.activity,
        BottomNavData.settings,
        )
    /* Bottom Navigation */
    BottomNavigation(
        backgroundColor = Black_alpha
    ) {
        items.forEach { item ->


            BottomNavigationItem(
                selected = currentRoute == item.rout,

                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

                        if (currentRoute == item.rout) {

                            Divider(
                                thickness = 3.dp,
                                color = White,
                                modifier = Modifier.width(39.dp)
                            )

                        } else {
                            White
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = item.title,
                            modifier = Modifier.size(26.dp),
                            tint = if (currentRoute == item.rout

                            ) {
                                White
                            } else {
                                Color.Unspecified
                            }
                        )

                    }


                },
                selectedContentColor = White,
                unselectedContentColor = Sub_Text,
                label = { Text(text = item.title) },
                alwaysShowLabel = true,
                onClick = {
                    navController.navigate(item.rout) {
                        popUpTo(BottomRouts.HOME) {

                            inclusive = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )

        }
    }

}
