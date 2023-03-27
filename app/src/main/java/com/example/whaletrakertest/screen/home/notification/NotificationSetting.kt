package com.example.whaletrakertest.screen.home.notification


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whaletrakertest.R
import com.example.whaletrakertest.screen.CustomSwitch
import com.example.whaletrakertest.ui.theme.Divider_color
import com.example.whaletrakertest.ui.theme.Sub_Text
import com.example.whaletrakertest.ui.theme.White

@Composable
fun NotificationSetting() {

    var switch by remember { mutableStateOf(false) }
    var switch2 by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 20.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Customise your notification preferences based\n" +
                        "on your personal preferences",
                fontWeight = FontWeight.Normal,
                color = Color.White,

                textAlign = TextAlign.Start,
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.basisgrotesquearabicpro_regular))
            )


            Spacer(modifier = Modifier.height(24.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .clickable { }
                    .fillMaxWidth()

            ) {

                Column() {
                    Text(
                        text = "Alerts",
                        fontWeight = FontWeight.Medium,
                        color = Color.White,

                        textAlign = TextAlign.Start,
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.basisgrotesquearabicpro_medium))
                    )

                    Text(
                        text = "Get notified when a whale’s token balance\n" +
                                "drop below a certain amount",
                        fontWeight = FontWeight.Normal,
                        color = Sub_Text,
                        textAlign = TextAlign.Start,
                        fontSize = 15.sp,
                        fontFamily = FontFamily(Font(R.font.basisgrotesquearabicpro_regular)),

                        )
                }
                CustomSwitch(switchOn = switch){
                    switch=!switch
                }

            }
            Spacer(modifier = Modifier.height(20.dp))
            Divider(thickness = 1.dp, color = Divider_color, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .clickable { }
                    .fillMaxWidth()


            ) {

                Column() {
                    Text(
                        text = "Transactions",
                        fontWeight = FontWeight.Medium,
                        color = Color.White,

                        textAlign = TextAlign.Start,
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.basisgrotesquearabicpro_medium))
                    )

                    Text(
                        text = "Get notified every time a transaction is \n" +
                                "made by a whale",
                        fontWeight = FontWeight.Normal,
                        color = Sub_Text,
                        textAlign = TextAlign.Start,
                        fontSize = 15.sp,
                        fontFamily = FontFamily(Font(R.font.basisgrotesquearabicpro_regular)),

                        )
                }
                CustomSwitch(switchOn = switch2){
                    switch2=!switch2
                }

            }

        }

        OutlinedButton(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .padding(
                    bottom = 20.dp
                )
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .height(55.dp)
                .clip(RoundedCornerShape(30.dp)),
            enabled = true,
            onClick = {

            },
            colors = ButtonDefaults.outlinedButtonColors(
                backgroundColor = White,
                contentColor = Color.White
            ),
            border = BorderStroke(0.dp, Color.Transparent)
        ) {
            Box(Modifier.fillMaxWidth()) {
                Text(
                    text = "Done",
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(R.font.basisgrotesquearabicpro_medium)),
                    fontSize = 16.sp,
                    letterSpacing = 0.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.Black
                )

//                if (processing) {
//                    CircularProgressIndicator(
//                        modifier = Modifier
//                            .size(25.dp)
//                            .align(Alignment.CenterEnd),
//                        color = Color.White,
//                        strokeWidth = 2.dp
//                    )
//                }
            }
        }

    }
}
