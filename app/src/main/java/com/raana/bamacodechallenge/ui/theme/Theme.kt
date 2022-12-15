package com.raana.bamacodechallenge.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.animation.animateColorAsState


private val colorPalette = lightColors(
    primary = primary,
    primaryVariant = primaryVariant,
    secondary = secondary,
    background = background,
    onSurface = onSurface,
)

@Composable
fun MyTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider {
        MaterialTheme(
            colors = colorPalette,
            shapes = shapes,
            content = content,
        )
    }
}