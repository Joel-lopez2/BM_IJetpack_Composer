package org.insbaixcamp.bmijetpackcomposer.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val EldenDarkColorScheme = darkColorScheme(
    primary = EldenGold,
    secondary = EldenDarkGold,
    tertiary = EldenCrimson,
    background = EldenBackground,
    surface = EldenSurface,
    onPrimary = Color.Black,
    onSecondary = Color.White,
    onBackground = EldenTextPrimary,
    onSurface = EldenTextPrimary,
)

@Composable
fun BMIJetpackComposerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = EldenDarkColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
