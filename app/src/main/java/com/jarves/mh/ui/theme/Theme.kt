package com.jarves.mh.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

val PocketMint = Color(0xFF4AD6AD)
val PocketBlue = Color(0xFF8BC9BC)
val PocketGreen = Color(0xFF75C98D)
val PocketBackground = Color(0xFF0B1512)
val PocketSurface = Color(0xFF111F1A)
val PocketSurfaceVariant = Color(0xFF1A2B24)
val PocketOutline = Color(0xFF30463C)

private val DarkColors = darkColorScheme(
    primary = PocketMint,
    onPrimary = Color(0xFF08271E),
    primaryContainer = Color(0xFF174638),
    onPrimaryContainer = Color(0xFFC1F4E4),
    secondary = PocketBlue,
    onSecondary = Color(0xFF15372E),
    tertiary = PocketGreen,
    onTertiary = Color(0xFF00391E),
    background = PocketBackground,
    onBackground = Color(0xFFE6EDF3),
    surface = PocketSurface,
    onSurface = Color(0xFFE6EDF3),
    surfaceVariant = PocketSurfaceVariant,
    onSurfaceVariant = Color(0xFF9AA0A6),
    outline = PocketOutline,
    outlineVariant = Color(0xFF333B4A),
)

private val LightColors = lightColorScheme(
    primary = Color(0xFF087F5B),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFD3F5E8),
    onPrimaryContainer = Color(0xFF073B2B),
    secondary = Color(0xFF4E8376),
    onSecondary = Color(0xFFFFFFFF),
    tertiary = Color(0xFF658A36),
    onTertiary = Color(0xFFFFFFFF),
    background = Color(0xFFF2F7F4),
    onBackground = Color(0xFF17221D),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF17221D),
    surfaceVariant = Color(0xFFE4EEE8),
    onSurfaceVariant = Color(0xFF4E6258),
    outline = Color(0xFFB8C9BF),
    outlineVariant = Color(0xFFD2E0D8),
)

enum class AppThemeMode { SYSTEM, DARK, LIGHT }

@Composable
fun PocketTheme(themeMode: AppThemeMode = AppThemeMode.SYSTEM, content: @Composable () -> Unit) {
    val isDark = when (themeMode) {
        AppThemeMode.DARK -> true
        AppThemeMode.LIGHT -> false
        AppThemeMode.SYSTEM -> isSystemInDarkTheme()
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as? Activity)?.window ?: return@SideEffect
            val insetsController = WindowCompat.getInsetsController(window, view)
            insetsController.isAppearanceLightStatusBars = !isDark
            insetsController.isAppearanceLightNavigationBars = !isDark
        }
    }

    MaterialTheme(
        colorScheme = if (isDark) DarkColors else LightColors,
        content = content,
    )
}
