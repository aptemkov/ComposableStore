package com.github.aptemkov.onlinestore.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.github.aptemkov.onlinestore.R

val monserrat = FontFamily(
    Font(R.font.montserrat_medium_500, FontWeight.Medium),
    Font(R.font.montserrat_semibold_600, FontWeight.SemiBold),
    Font(R.font.montserrat_bold_700, FontWeight.Bold),
    Font(R.font.montserrat_thin_100, FontWeight.Thin),
    Font(R.font.montserrat_light_300, FontWeight.Light),
)

// Set of Material typography styles to start with
val Typography = Typography(
    headlineLarge = TextStyle(
        fontFamily = monserrat,
        fontWeight = FontWeight.Bold,
    ),
    bodyLarge = TextStyle(
        fontFamily = monserrat,
        fontWeight = FontWeight.SemiBold
    ),
    bodyMedium = TextStyle(
        fontFamily = monserrat,
        fontWeight = FontWeight.Medium
    ),
    bodySmall = TextStyle(
        fontFamily = monserrat,
        fontWeight = FontWeight.Light
    ),

)