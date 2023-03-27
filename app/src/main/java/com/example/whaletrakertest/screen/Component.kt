package com.example.whaletrakertest.screen

import android.annotation.SuppressLint

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.whaletrakertest.R
import com.example.whaletrakertest.ui.theme.White


@Composable
fun ButtonWIthIcon(modifier: Modifier = Modifier, text: String, onclick: (() -> Unit)?) {
    val progress = remember { mutableStateOf(false) }
    Button(
        onClick = {
            progress.value = true
            onclick?.invoke()
        },
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = White,
            contentColor = androidx.compose.ui.graphics.Color.Black
        ), modifier = modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.weight(0.25f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.add_icon),
                contentDescription = null,
                tint = androidx.compose.ui.graphics.Color.Black,
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
            )

        }
        Text(
            text = text,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center,
            fontSize = 15.sp,
            fontFamily = FontFamily(
                Font(R.font.basisgrotesquearabicpro_medium)
            )
        )

    }
}

@Composable
fun OutLineFields(
    value: String,
    onValueChange: (String) -> Unit,
    placeholders: String,
    modifier: Modifier,
//    isError: Boolean = false,
//    trailingIcon: @Composable (() -> Unit)? = null,
) {

    OutlinedTextField(
        value = value, onValueChange = onValueChange, singleLine = true,
        placeholder = { Text(text = placeholders) },
        colors = TextFieldDefaults.textFieldColors(
            textColor = androidx.compose.ui.graphics.Color.White,
            disabledTextColor = androidx.compose.ui.graphics.Color.Transparent,
            focusedIndicatorColor = androidx.compose.ui.graphics.Color.Transparent,
            unfocusedIndicatorColor = androidx.compose.ui.graphics.Color.Transparent,
            disabledIndicatorColor = androidx.compose.ui.graphics.Color.Transparent,
            placeholderColor = androidx.compose.ui.graphics.Color.White.copy(alpha = 0.8f),
            backgroundColor = androidx.compose.ui.graphics.Color.Black
        ),
        modifier = modifier,
    )


}

@Composable
fun CustomSwitch(
    width: Dp = 29.33.dp,
    height: Dp = 18.67.dp,

    gapBetweenThumbAndTrackEdge: Dp = 4.dp,
    borderWidth: Dp = 2.dp,
    cornerSize: Int = 50,
    iconInnerPadding: Dp = 4.dp,

    switchOn: Boolean,
    onSwitch: () -> Unit = {}
) {

    // this is to disable the ripple effect
    val interactionSource = remember {
        MutableInteractionSource()
    }

    // state of the switch
//    var switchOn by remember {
//        mutableStateOf(true)
//    }

    // for moving the thumb
    val alignment by animateAlignmentAsState(if (switchOn) 1f else -1f)

    // outer rectangle with border
    Box(
        modifier = Modifier
            .size(width = width, height = height)
            .border(
                width = borderWidth,
                color = White,
                shape = RoundedCornerShape(percent = cornerSize)
            )
            .clickable(
                indication = null,
                interactionSource = interactionSource
            ) {
                onSwitch.invoke()
            },
        contentAlignment = Alignment.Center
    ) {

        // this is to add padding at the each horizontal side
        Box(
            modifier = Modifier
                .padding(
                    start = gapBetweenThumbAndTrackEdge,
                    end = gapBetweenThumbAndTrackEdge
                )
                .fillMaxSize(),
            contentAlignment = alignment
        ) {
            Box(
                modifier = Modifier
                    .width(10.dp)
                    .height(10.dp)
                    .clip(shape = CircleShape)
                    .background(White)
                    .padding(all = iconInnerPadding)
            )           // thumb with icon

        }
    }

}

@SuppressLint("UnrememberedMutableState")
@Composable
private fun animateAlignmentAsState(
    targetBiasValue: Float
): State<BiasAlignment> {
    val bias by animateFloatAsState(targetBiasValue)
    return derivedStateOf { BiasAlignment(horizontalBias = bias, verticalBias = 0f) }
}


