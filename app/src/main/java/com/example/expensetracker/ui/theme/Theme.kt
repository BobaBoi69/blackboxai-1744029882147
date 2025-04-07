package com.example.expensetracker.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val GlassWhite = Color(0xCCFFFFFF)
val GlassBlack = Color(0xCC000000)
val GlassPrimary = Color(0xCC6200EE)

@Composable
fun ExpenseTrackerTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) darkColorScheme else lightColorScheme,
        typography = Typography,
        content = content
    )
}

private val lightColorScheme = androidx.compose.material3.lightColorScheme(
    primary = GlassPrimary,
    onPrimary = Color.White,
    surface = GlassWhite,
    onSurface = Color.Black
)

private val darkColorScheme = androidx.compose.material3.darkColorScheme(
    primary = GlassPrimary,
    onPrimary = Color.White,
    surface = GlassBlack,
    onSurface = Color.White
)