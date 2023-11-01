package com.raana.composeSample.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.raana.composeSample.ui.theme.white

@Composable
fun MyTopAppBar(
    title: String
) {
    Surface(modifier = Modifier.fillMaxWidth()) {
        TopAppBar(title = {
            Box(
                modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
            ) {
                Text(text = title, color = white)
            }
        })
    }
}