package com.asadmansoor.jetpup.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.asadmansoor.jetpup.R


val Typography = Typography(
    h1 = TextStyle(
        fontFamily = FontFamily(Font(resId = R.font.varela_round)),
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp
    ),
    h6 = TextStyle(
        fontFamily = FontFamily(Font(resId = R.font.varela_round)),
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    )
)