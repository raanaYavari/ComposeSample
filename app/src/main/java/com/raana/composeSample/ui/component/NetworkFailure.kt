package com.raana.composeSample.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.raana.composeSample.ui.theme.primaryColor

@Composable
fun NetworkFailure(modifier: Modifier, message: String?, onRedoClick: () -> Unit) {

    Column(
        modifier
            .clickable { onRedoClick() }, horizontalAlignment = Alignment.CenterHorizontally
    , verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier.size(32.dp),
            imageVector = Icons.Default.Refresh,
            contentDescription = "Refresh",
            colorFilter = ColorFilter.tint(primaryColor)
        )
        Text(
            modifier = Modifier.padding(8.dp),
            text = message
                ?: stringResource(id = com.raana.composeSample.R.string.error_message),
            style = MaterialTheme.typography.caption,
            textAlign = TextAlign.Center
        )
    }

}